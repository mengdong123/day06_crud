package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 导航栏退出功能
 * @author 51019
 *
 */
@WebServlet("/mng/exit")
public class ExitServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		
		//2.执行业务逻辑
		HttpSession session = req.getSession();
		session.removeAttribute("curr_mrg");
		//3.返回响应
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
	}

}
