package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Product;
import com.lzx.common.DaoFactory;
@WebServlet("/mng/pro/search")
public class ProductSearchName extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		
		String search = new String("%"+req.getParameter("search")+"%");
		
		//2.ִ��ҵ���߼�
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		//�õ���������ģ����ѯ�����б�
		
		List<Product> list = productDao.searchByname(search);
		req.setAttribute("search_pro", list);
		//3.������Ӧ
		req.getRequestDispatcher("/mng/pro/search.jsp").forward(req, resp);
		
	}

}
