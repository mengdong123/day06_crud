package com.lzx.dao.common;

import java.util.List;

/**
 * 基于泛型通用Dao接口层
 * 
 * @author liqingkun7
 *
 */
public interface BaseDao<T> {

	/**
	 * 保存
	 * 
	 * @param
	 */
	public void save(T t);

	/**
	 * 根据ID,查找某条数据
	 * 
	 * @param id
	 * @return
	 */
	public T findOne(int id);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 根据ID,进行更新
	 * 
	 * @param dept
	 */
	public void update(T people);

	/**
	 * 根据id，进行删除
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 根据指定SQL语句和参数进行更新
	 * 
	 * @param sql
	 * @param params
	 */
	public void update(String sql, Object... params);

	/**
	 * 根据指定SQL语句和参数进行查询
	 * 
	 * @param sql
	 * @param params
	 */
	public List<T> find(String sql, Object... params);

	/**
	 * 根据指定SQL语句和参数进行单条数据查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public T findOne(String sql, Object... params);

	/**
	 * 查询总条数
	 * 
	 * @return
	 */
	public Long count();

}
