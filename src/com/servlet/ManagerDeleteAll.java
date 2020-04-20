package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerDao;
import com.lzx.common.DaoFactory;

@WebServlet("/mng/man/delete_all")
public class ManagerDeleteAll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.获取请求数据
		// 2.执行业务逻辑
		ManagerDao managerDao = (ManagerDao) DaoFactory.getInstance("managerDao");
		System.out.println("manager[delete_all]===========================");
		//获取地址栏传归来的id
		String ids = req.getParameter("ids");
		//将地址栏传过来的id用“，”分开
		String[] split = ids.split(",");
		//加强for循环将传过来的id依次删除
		for (String id : split) {
			managerDao.delete(Long.parseLong(id));
		}
		//3.返回响应
		resp.sendRedirect(req.getContextPath()+"/mng/man/list?number=1&size=2");
	}

}
