package com.lzx.dao.Impl;

import java.util.List;

import com.dao.ProductDao;
import com.entity.News;
import com.entity.Page;
import com.entity.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
	@Override
	public Page<Product> findByPage(int number, int size) {
		Page<Product> page = new Page<>();
		page.setNumber(number);
		page.setSize(size);
		// 总条数
		Long count = count();
		page.setTotalcount(count);
		// 总页数
		if (count % size == 0) {
			page.setTotalpage(count % size);
		} else {
			page.setTotalpage(count % size + 1);
		}
		// 根据sql语句查找当前页数的集合
		// select * from product limit (number-1)*size,size;
		String sql = "select * from product limit ?,?";
		page.setItems(this.find(sql, new Object[] { (number - 1) * size, size }));

		return page;

	}

	@Override
	public List<Product> searchByname(String search) {
		String sql = "select * from product where name like ?";
		
		System.out.println(search);
		List<Product> list = this.find(sql, new Object[] {search});
		return list;
	}

}
