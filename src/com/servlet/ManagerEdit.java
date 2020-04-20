package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.lzx.common.DaoFactory;
/**
 * 管理员编辑
 * @author 51019
 *
 */
@WebServlet("/mng/man/edit")
public class ManagerEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		String id = req.getParameter("id");
		//2.执行业务逻辑
	    ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
	    Manager manager = managerDao.findOne(Integer.parseInt(id));
	    req.setAttribute("manageredit", manager);
		//3.返回响应
		req.getRequestDispatcher("/mng/man/edit.jsp").forward(req, resp);
	}

}
