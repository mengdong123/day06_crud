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
 * ʹ��common-dbutils��,ʵ��ͨ��Daoʵ����
 * 
 * @author liqingkun7
 *
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	// SQLִ����
	private QueryRunner qr = new QueryRunner();
	// ���������ĳһ����¼������ĳһ�е����ݴ�� Object��
	private ScalarHandler<Long> scHandler = new ScalarHandler<>();
	// ��������еĵ�һ�����ݷ�װ��һ����Ӧ��JavaBeanʵ���С� ע�⣬�������Ҫ��JavaBean����������ͬ��
	private BeanHandler<T> beanHandler;
	// BeanListHanlder�ࣺ��������е�ÿһ�����ݶ���װ��һ����Ӧ��JavaBeanʵ���У���ŵ�List�ע�⣬�������Ҫ��JavaBean����������ͬ
	private BeanListHandler<T> beanListHandler;
	// ����
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/* ��ǰҪ����ʵ������� */
	private Class<T> clazz;

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * ���췽�� ��ͨ��������ƻ�ȡ���ഫ�ݹ�����ʵ������Ϣ������--->Сд��������
	 */
	public BaseDaoImpl() {
		// 1����ȡ����
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0]; // BaseDao<T>
		// 2����ȡ BeanHandler,BeanListHandler����
		beanHandler = new BeanHandler<>(clazz);
		beanListHandler = new BeanListHandler<>(clazz);
		// ʵ��������ȫ��Сд
		tableName = clazz.getSimpleName().toLowerCase();
	}

	@Override
	public void save(T t) {
		// INSERT INTO ����(����1������2������3 .....) VALUES(?,?,?....);
		StringBuilder values = new StringBuilder(); // ƴ��벿????
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
			sb.append(map.getKey()); // �ֶ���
			values.append(" ? ");
			list_value.add(map.getValue()); // �ֶ�ֵ
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
		// UPDATE ���� SET ����=�� ,xxxx;
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
			sb.append(map.getKey()); // �ֶ���
			sb.append(" = ? ");
			list_value.add(map.getValue()); // �ֶ�ֵ
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
	 * ͨ��������ƣ���ȡָ��ʵ����������-->ʵ�����Ӧ��ֵ map����
	 * 
	 * @param entity
	 * @return
	 */
	public Map<String, Object> getFileValueMap(T entity) {

		Map<String, Object> hashMap = new HashMap<String, Object>();
		// ͨ��������ƻ�ȡʵ��������������
		Field[] fields = this.clazz.getDeclaredFields();
		// ��ȡ����������
		Field[] parent = this.clazz.getSuperclass().getDeclaredFields();

		// �������Ժ�ֵ
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			// ������
			String name = f.getName();
			// �������л�
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				f.setAccessible(true); // ȡ��Java���Է��ʼ��
				// ͨ�����������������Ӧ
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

		// �������Ժ�ֵ
		for (int i = 0; i < parent.length; i++) {
			Field f = parent[i];
			// ������
			String name = f.getName();
			// �������л�
			if (!"serialVersionUID".equalsIgnoreCase(name)) {
				f.setAccessible(true); // ȡ��Java���Է��ʼ��
				// ͨ�����������������Ӧ
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
