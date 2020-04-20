package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.News;
import com.entity.Page;
import com.entity.Product;
import com.lzx.common.DaoFactory;
@WebServlet("/mng/pro/list")
public class ProductListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		
		//2.执行业务逻辑
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		Page<Product> list = productDao.findByPage(Integer.parseInt(req.getParameter("number")),Integer.parseInt(req.getParameter("size")));
		req.setAttribute("productlist", list);
		//3.做出请求
		req.getRequestDispatcher("/mng/pro/list.jsp").forward(req, resp);
	}
}
