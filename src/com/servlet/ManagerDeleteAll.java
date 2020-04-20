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

		// 1.��ȡ��������
		// 2.ִ��ҵ���߼�
		ManagerDao managerDao = (ManagerDao) DaoFactory.getInstance("managerDao");
		System.out.println("manager[delete_all]===========================");
		//��ȡ��ַ����������id
		String ids = req.getParameter("ids");
		//����ַ����������id�á������ֿ�
		String[] split = ids.split(",");
		//��ǿforѭ������������id����ɾ��
		for (String id : split) {
			managerDao.delete(Long.parseLong(id));
		}
		//3.������Ӧ
		resp.sendRedirect(req.getContextPath()+"/mng/man/list?number=1&size=2");
	}

}
