package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.lzx.common.DaoFactory;
/**
 * 个人信息
 * @author 51019
 *
 */
@WebServlet("/person/info")
public class PersonInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		HttpSession session = req.getSession();
		Manager man = (Manager)session.getAttribute("curr_mrg");
		//2.执行业务逻辑
		req.setAttribute("person_info", man);
		//3.返回响应
		req.getRequestDispatcher("/mng/person/info.jsp").forward(req, resp);
	}

}
