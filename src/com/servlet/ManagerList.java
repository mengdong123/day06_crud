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
import com.entity.Page;
import com.lzx.common.DaoFactory;
/*
 * ����Ա�б�
 */
@WebServlet("/mng/man/list")
public class ManagerList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		
		//2.ִ��ҵ���߼�
		ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
		Page<Manager> list = managerDao.findByPage(Integer.parseInt(req.getParameter("number")),Integer.parseInt(req.getParameter("size")));
		//����������ɴ���ֵ
		req.setAttribute("managerlist",list);
		
		req.getRequestDispatcher("/mng/man/list.jsp").forward(req, resp);
	}

}
