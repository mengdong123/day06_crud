package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.lzx.common.DaoFactory;
/*
 * ɾ����Ʒ����
 * 
 */
@WebServlet("/mng/pro/delete")
public class ProductDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		String id = req.getParameter("id");
		//2.ִ��ҵ���߼�
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		productDao.delete(Long.parseLong(id));
		//3.��������
		resp.sendRedirect(req.getContextPath()+"/mng/pro/list?number=1&size=2");
	}
}
