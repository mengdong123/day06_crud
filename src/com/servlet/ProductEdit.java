package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Product;
import com.lzx.common.DaoFactory;
/*
 * 商品编辑功能
 */
@WebServlet("/mng/pro/edit")
public class ProductEdit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		Product product= new Product();
		
		//2.执行业务逻辑
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		product = productDao.findOne(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("memberedit", product);
		//3.做出响应
		req.getRequestDispatcher("/mng/pro/edit.jsp").forward(req, resp);
	}
}
