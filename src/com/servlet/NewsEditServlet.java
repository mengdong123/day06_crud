package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.NewsDao;
import com.entity.News;
import com.lzx.common.DaoFactory;
/**
 * 菜单编辑功能
 * @author 51019
 *
 */
@WebServlet("/mng/news/edit")
public class NewsEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.获取请求资源
		String id = req.getParameter("id");
		//2.执行业务逻辑
		NewsDao newsDao = (NewsDao) DaoFactory.getInstance("newsDao");
		News newsedit = newsDao.findOne(Integer.parseInt(id));
		//3.处理请求
		req.setAttribute("newsedit", newsedit);
		req.getRequestDispatcher("/mng/news/edit.jsp").forward(req, resp);
	}

}
