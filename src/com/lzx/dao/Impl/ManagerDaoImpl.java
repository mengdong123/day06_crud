package com.lzx.dao.Impl;

import java.util.List;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.entity.Page;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao{

	@Override
	public Manager login(String lname, String pwd) {
		// TODO Auto-generated method stub\
		//�ж��û����������Ƿ���ȷ
		String sql= "select * from manager where lname = ? and pwd = ?";
		return this.findOne(sql, new Object[] {lname , pwd});
	}

	@Override
	public Page<Manager> findByPage(int number, int size) {
		Page<Manager> page= new Page<>();
		page.setNumber(number);
		page.setSize(size);
		//������
		Long count = count();
		page.setTotalcount(count);
		//��ҳ��
		if(count%size==0) {
			page.setTotalpage(count%size);
		}else {
			page.setTotalpage(count%size+1);
		}
		//����sql�����ҵ�ǰҳ���ļ���
		//select * from news limit (number-1)*size,size;
		String sql = "select * from manager limit ?,?";
		page.setItems(this.find(sql, new Object[] {(number-1)*size,size}));
		
		
		return page;
		
	}
     //ģ����ѯ����
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
