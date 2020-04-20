package com.lzx.dao.Impl;

import java.util.List;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.entity.Page;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao{

	@Override
	public Manager login(String lname, String pwd) {
		// TODO Auto-generated method stub\
		//判断用户名和密码是否正确
		String sql= "select * from manager where lname = ? and pwd = ?";
		return this.findOne(sql, new Object[] {lname , pwd});
	}

	@Override
	public Page<Manager> findByPage(int number, int size) {
		Page<Manager> page= new Page<>();
		page.setNumber(number);
		page.setSize(size);
		//总条数
		Long count = count();
		page.setTotalcount(count);
		//总页数
		if(count%size==0) {
			page.setTotalpage(count%size);
		}else {
			page.setTotalpage(count%size+1);
		}
		//根据sql语句查找当前页数的集合
		//select * from news limit (number-1)*size,size;
		String sql = "select * from manager limit ?,?";
		page.setItems(this.find(sql, new Object[] {(number-1)*size,size}));
		
		
		return page;
		
	}
     //模糊查询方法
	@Override
	public List<Manager> searchByName(String search) {
		String sql = "select * from manager where lname like ?";
		List<Manager> list = this.find(sql, new Object[] {search});
		return list;
	}

	@Override
	public void deleteALL(List delete_id) {
		// TODO Auto-generated method stub
		String sql = "delete *";
		
	}

}
