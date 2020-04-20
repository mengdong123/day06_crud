package com.lzx.dao.Impl;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lzx.common.DBHelper;
import com.lzx.dao.common.BaseDao;
//import com.lzx.entity.common.Page;

/**
 * 使用common-dbutils包,实现通用Dao实现类
 * 
 * @author liqingkun7
 *
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	// SQL执行器
	private QueryRunner qr = new QueryRunner();
	// 将结果集中某一条记录的其中某一列的数据存成 Object。
	private ScalarHandler<Long> scHandler = new ScalarHandler<>();
	// 将结果集中的第一行数据封装到一个对应的JavaBean实例中。 注意，表的列名要跟JavaBean的属性名相同。
	private BeanHandler<T> beanHandler;
	// BeanListHanlder类：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。注意，表的列名要跟JavaBean的属性名相同
	private BeanListHandler<T> beanListHandler;
	// 表名
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/* 当前要操作实体类对象 */
	private Class<T> clazz;

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 构造方法 会通过反射机制获取子类传递过来的实体类信息，类名--->小写（表名）
	 */
	public BaseDaoImpl() {
		// 1、获取表名
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0]; // BaseDao<T>
		// 2、获取 BeanHandler,BeanListHandler对象
		beanHandler = new BeanHandler<>(clazz);
		beanListHandler = new BeanListHandler<>(clazz);
		// 实体类名称全部小写
		tableName = clazz.getSimpleName().toLowerCase();
	}

	@Override
	public void save(T t) {
		// INSERT INTO 表名(列名1，列名2，列名3 .....) VALUES(?,?,?....);
		StringBuilder values = new StringBuilder(); // 拼后半部????
		StringBuilder sb = new StringBuilder("");
		sb.append("INSERT  INTO ");
		sb.append(tableName);
		sb.append(" (  ");
		Map<String, Object> fileValueMap = getFileValueMap(t);
		fileValueMap.remove("id");
		List<Object> list_value = new ArrayList<Object>();
		int i = 0;
		for (Map.Entry<String, Object> map : fileValueMap.entrySet()) {
			if (i++ > 0) {
				values.append(",");
				sb.append(",");
			}
			sb.append(map.getKey()); // 字段名
			values.append(" ? ");
			list_value.add(map.getValue()); // 字段值
		}

		sb.append(" ) ");
		sb.append(" VALUES ( ");
		sb.append(values);
		sb.append(" ) ");
		Connection conn = DBHelper.getConnection();
		try {
			qr.insert(conn, sb.toString(), scHandler, list_value.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}

	}

	@Override
	public T findOne(int id) {
		StringBuilder sb = new StringBuilder("SELECT  *  FROM  ");
		sb.append(tableName);
		sb.append(" WHERE  id = ");
		sb.append("?");
		Connection conn = DBHelper.getConnection();
		T object = null;
		try {
			object = qr.query(conn, sb.toString(), id, beanHandler);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}
		return object;
	}

	@Override
	public List<T> findAll() {
		StringBuilder sb = new StringBuilder("SELECT  *  FROM  ");
		sb.append(tableName);
		Connection conn = DBHelper.getConnection();
		List<T> list = null;
		try {
			list = qr.query(conn, sb.toString(), beanListHandler);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public void update(T t) {
		// UPDATE 表名 SET 列名=？ ,xxxx;
		StringBuilder sb = new StringBuilder("");
		sb.append("UPDATE ");
		sb.append(tableName);
		sb.append(" SET  ");
		Map<String, Object> fileValueMap = getFileValueMap(t);
		List<Object> list_value = new ArrayList<Object>();
		int i = 0;
		for (Map.Entry<String, Object> map : fileValueMap.entrySet()) {
			if (i++ > 0) {
				sb.append(",");
			}
			sb.append(map.getKey()); // 字段名
			sb.append(" = ? ");
			list_value.add(map.getValue()); // 字段值
		}

		sb.append(" WHERE   ");
		sb.append("  id = ? ");
		System.out.println(sb.toString());
		list_value.add(fileValueMap.get("id"));

		Connection conn = DBHelper.getConnection();
		try {
			qr.update(conn, sb.toString(), list_value.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}

	}

	@Override
	public void delete(Long id) {
		StringBuilder sql = new StringBuilder("DELETE  FROM  ");
		sql.append(tableName);
		sql.append(" WHERE  id = ?");
		Connection conn = DBHelper.getConnection();
		try {
			qr.update(conn, sql.toString(), id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}

	}

	@Override
	public void update(String sql, Object... params) {
		Connection conn = DBHelper.getConnection();
		try {
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}
	}

	@Override
	public List<T> find(String sql, Object... params) {
		Connection conn = DBHelper.getConnection();
		List<T> list = null;
		try {
			list = qr.query(conn, sql, params, beanListHandler);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public T findOne(String sql, Object... params) {
		Connection conn = DBHelper.getConnection();
		T t = null;
		try {
			t = qr.query(conn, sql, params, beanHandler);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}
		return t;
	}

	/***
	 * 通过反射机制，获取指定实体类属性名-->实体类对应的值 map对象
	 * 
	 * @param entity
	 * @return
	 */
	public Map<String, Object> getFileValueMap(T entity) {

		Map<String, Object> hashMap = new HashMap<String, Object>();
		// 通过反射机制获取实体类中所有属性
		Field[] fields = this.clazz.getDeclaredFields();
		// 获取父类属性名
		Field[] parent = this.clazz.getSuperclass().getDeclaredFields();

		// 子类属性和值
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			// 属性名
			String name = f.getName();
			// 忽略序列化
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				f.setAccessible(true); // 取消Java语言访问检查
				// 通过反射属性所对象的应
				Object object;
				try {
					object = f.get(entity);
					hashMap.put(name, object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}

		// 父类属性和值
		for (int i = 0; i < parent.length; i++) {
			Field f = parent[i];
			// 属性名
			String name = f.getName();
			// 忽略序列化
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				f.setAccessible(true); // 取消Java语言访问检查
				// 通过反射属性所对象的应
				Object object;
				try {
					object = f.get(entity);
					hashMap.put(name, object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}

		return hashMap;
	}

	@Override
	public Long count() {
		StringBuilder sb = new StringBuilder("SELECT  count(id)  FROM  ");
		sb.append(tableName);
		Long c =0l;
		Connection conn = DBHelper.getConnection();
		try {
			c = qr.query(conn, sb.toString(), scHandler);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(conn);
		}
		return c;
	}

}
