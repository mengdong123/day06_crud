package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.lzx.common.DaoFactory;
/*
 * 删除商品功能
 * 
 */
@WebServlet("/mng/pro/delete")
public class ProductDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		String id = req.getParameter("id");
		//2.执行业务逻辑
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		productDao.delete(Long.parseLong(id));
		//3.返回请求
		resp.sendRedirect(req.getContextPath()+"/mng/pro/list?number=1&size=2");
	}
}
