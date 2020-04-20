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
 * 修改密码
 * 
 * @author 51019
 *
 */
@WebServlet("/mng/person/pwd")
public class PersonPwd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求数据
		 //拿到登录用户
		HttpSession session = req.getSession();
		Manager man = (Manager)session.getAttribute("curr_mrg");
		 //拿到旧新密码
		String old_pwd = req.getParameter("old_pwd");
		String new_pwd = req.getParameter("new_pwd");
		String again_pwd = req.getParameter("again_pwd");
		//2.执行业务逻辑
		String mes = "";
		//判断输入的旧密码是否输入正确
		if(man.getPwd().equals(old_pwd)) {
			//判断两次新密码是否输入一致
			if(new_pwd.equals(again_pwd)) {
			   //将新密码保存至数据库
		         ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
		         man.setPwd(new_pwd);
		         managerDao.update(man);
		         mes = "密码修改成功，请重新登录";
		         req.setAttribute("msg",mes);	 
				 req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}else {
				mes = "两次密码输入不一致，请重新输入";
				req.setAttribute("mes", mes);
				req.getRequestDispatcher("/mng/person/pwd.jsp").forward(req, resp);
			}
		}else {
			mes = "旧密码输入错误，请重新输入";
			req.setAttribute("mes", mes);
			req.getRequestDispatcher("/mng/person/pwd.jsp").forward(req, resp);	
		}
		
		
		
		//3.返回响应
	}

}
