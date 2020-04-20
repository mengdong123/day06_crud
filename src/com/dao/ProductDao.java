package com.dao;

import java.util.List;

import com.entity.Page;
import com.entity.Product;
import com.lzx.dao.common.BaseDao;

public interface ProductDao extends BaseDao<Product>{

	public Page<Product> findByPage(int number, int size);
	public List<Product> searchByname(String search);

}
