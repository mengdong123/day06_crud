package com.lzx.dao.common;

import java.util.List;

/**
 * ���ڷ���ͨ��Dao�ӿڲ�
 * 
 * @author liqingkun7
 *
 */
public interface BaseDao<T> {

	/**
	 * ����
	 * 
	 * @param
	 */
	public void save(T t);

	/**
	 * ����ID,����ĳ������
	 * 
	 * @param id
	 * @return
	 */
	public T findOne(int id);

	/**
	 * ��ѯȫ��
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * ����ID,���и���
	 * 
	 * @param dept
	 */
	public void update(T people);

	/**
	 * ����id������ɾ��
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * ����ָ��SQL���Ͳ������и���
	 * 
	 * @param sql
	 * @param params
	 */
	public void update(String sql, Object... params);

	/**
	 * ����ָ��SQL���Ͳ������в�ѯ
	 * 
	 * @param sql
	 * @param params
	 */
	public List<T> find(String sql, Object... params);

	/**
	 * ����ָ��SQL���Ͳ������е������ݲ�ѯ
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public T findOne(String sql, Object... params);

	/**
	 * ��ѯ������
	 * 
	 * @return
	 */
	public Long count();

}
