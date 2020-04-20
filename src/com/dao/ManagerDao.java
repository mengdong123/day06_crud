package com.dao;

import java.util.List;

import com.entity.Manager;
import com.entity.News;
import com.entity.Page;
import com.lzx.dao.common.BaseDao;

public interface ManagerDao extends BaseDao<Manager>{
	//��ӵ�¼����֤�û���������
	public Manager login(String lname,String pwd);
	//��ҳ����
	public Page<Manager> findByPage(int number, int size);
	//ģ����ѯ
	public List<Manager> searchByName(String search);
	public void deleteALL(List delete_id);
	

}
