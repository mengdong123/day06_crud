package com.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ���ﳵ��Ʒ���ͼ�깦��
 * @author 51019
 *
 */
@WebServlet("/mng/shopcar/valueadd")
public class ShopcarValueAdd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		HttpSession session = req.getSession();
		Map<String,Integer> shopcar = (Map<String, Integer>) session.getAttribute("shopcaradd");
		//2.ִ��ҵ���߼�
		//�õ���Ʒid
		String id = req.getParameter("id");
		//ͨ��id�ӹ��ﳵ���ҵ�����Ʒ�ĵ�value
		int value = shopcar.get(id);
		shopcar.put(id, ++value);
		
		//3.������Ӧ
		resp.sendRedirect(req.getContextPath()+"/mng/shop/list");
	}

}
