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
import com.entity.Page;
import com.lzx.common.DaoFactory;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/mng/news/list")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		NewsDao newsDao = (NewsDao) DaoFactory.getInstance("newsDao");
		Page<News> list = newsDao.findByPage(Integer.parseInt(req.getParameter("number")),Integer.parseInt(req.getParameter("size")));
		//利用请求分派传送值
		req.setAttribute("news",list);
		req.getRequestDispatcher("/mng/news/list.jsp").forward(req, resp);
	}

}
