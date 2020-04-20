package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzx.common.DaoFactory;

@WebServlet("/mng/shopcar/add")
public class ShopCarAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����Ự
		HttpSession session = req.getSession();
		//�鿴�Ƿ������ﳵ
		Map<String, Integer> shopcar = (Map<String, Integer>) session.getAttribute("shopcaradd");
		//�ж����޹��ﳵ
		
		if(shopcar == null){
			//�������ﳵ
			shopcar = new HashMap();
			
		}
		String id = req.getParameter("id");
		Integer value = shopcar.get(id);
		
		if(value != null) {
			shopcar.put(id, value+1);
			
		}else {
			shopcar.put(id,1);
			
		}
		session.setAttribute("shopcaradd", shopcar);
		
		resp.sendRedirect(req.getContextPath()+"/mng/shopcar/add.jsp");
		
	}

}
