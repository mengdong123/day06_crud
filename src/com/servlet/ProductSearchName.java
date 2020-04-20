package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Product;
import com.lzx.common.DaoFactory;
@WebServlet("/mng/pro/search")
public class ProductSearchName extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		
		String search = new String("%"+req.getParameter("search")+"%");
		
		//2.执行业务逻辑
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		//拿到搜索框里模糊查询出的列表
		
		List<Product> list = productDao.searchByname(search);
		req.setAttribute("search_pro", list);
		//3.返回响应
		req.getRequestDispatcher("/mng/pro/search.jsp").forward(req, resp);
		
	}

}
