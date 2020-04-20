package com.dao;

import java.util.List;

import com.entity.News;
import com.entity.Page;
import com.lzx.dao.common.BaseDao;

public interface NewsDao extends BaseDao<News>{

	public Page<News> findByPage(int number, int size);

	public List<News> searchByName(String search);

}
