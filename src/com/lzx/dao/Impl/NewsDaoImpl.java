package com.lzx.dao.Impl;

import java.util.List;

import com.dao.NewsDao;
import com.entity.News;
import com.entity.Page;

public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{

	@Override
	public Page<News> findByPage(int number, int size) {
		Page<News> page= new Page<>();
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
		String sql = "select * from news limit ?,?";
		page.setItems(this.find(sql, new Object[] {(number-1)*size,size}));
		
		
		return page;
		
	}

	@Override
	public List<News> searchByName(String search) {
		String sql = "select * from news where title like ?";
		List<News> list = this.find(sql, new Object[] {search});
		return list;
	}

}
