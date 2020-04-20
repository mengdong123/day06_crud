package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.NewsDao;
import com.entity.News;
import com.lzx.common.DaoFactory;
@WebServlet("/mng/news/delete")
public class NewsDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取删除id
		String id = req.getParameter("id");
		//执行业务逻辑
		NewsDao newsDao = (NewsDao) DaoFactory.getInstance("newsDao");
		newsDao.delete(Long.parseLong(id));
		//刷新页面
		resp.sendRedirect(req.getContextPath()+"/mng/news/list?number=1&size=2");
	
	}
}
