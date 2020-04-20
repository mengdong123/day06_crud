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
/**
 * news模糊查询
 * @author 51019
 *
 */
@WebServlet("/mng/news/search")
public class NewsSearch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	} 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1获取请求数据
		String search = new String("%"+req.getParameter("search")+"%");
		//2执行业务逻辑
		NewsDao newsDao = (NewsDao)DaoFactory.getInstance("newsDao");
		List<News> list = newsDao.searchByName(search);
		req.setAttribute("searchnews", list);
		//3返回响应
		req.getRequestDispatcher("/mng/news/search.jsp").forward(req, resp);
	}

}
