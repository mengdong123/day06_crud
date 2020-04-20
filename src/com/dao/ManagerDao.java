package com.dao;

import java.util.List;

import com.entity.Manager;
import com.entity.News;
import com.entity.Page;
import com.lzx.dao.common.BaseDao;

public interface ManagerDao extends BaseDao<Manager>{
	//添加登录的验证用户名和密码
	public Manager login(String lname,String pwd);
	//分页方法
	public Page<Manager> findByPage(int number, int size);
	//模糊查询
	public List<Manager> searchByName(String search);
	public void deleteALL(List delete_id);
	

}
