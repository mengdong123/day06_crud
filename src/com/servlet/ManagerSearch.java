package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.lzx.common.DaoFactory;
@WebServlet("/mng/man/search")
public class ManagerSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求数据
		String search = new String("%"+req.getParameter("search")+"%");
		//执行业务逻辑
	    ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
		List<Manager> list = managerDao.searchByName(search);
		req.setAttribute("searchmanager", list);
		//返回响应
		req.getRequestDispatcher("/mng/man/search.jsp").forward(req, resp);
	}
}
