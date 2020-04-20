package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ManagerDao;
import com.lzx.common.DaoFactory;
/**
 * ����Աɾ��
 * @author 51019
 *
 */
@WebServlet("/mng/man/delete")
public class ManagerDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		//2.ִ��ҵ���߼�
		ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
		managerDao.delete(Long.parseLong(req.getParameter("id")));
		//3.������Ӧ
		resp.sendRedirect(req.getContextPath()+"/mng/man/list?number=1&size=2");
	}

}
