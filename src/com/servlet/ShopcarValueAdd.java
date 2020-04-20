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
 * 购物车商品添加图标功能
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
		//1.获取请求数据
		HttpSession session = req.getSession();
		Map<String,Integer> shopcar = (Map<String, Integer>) session.getAttribute("shopcaradd");
		//2.执行业务逻辑
		//拿到商品id
		String id = req.getParameter("id");
		//通过id从购物车中找到该商品的的value
		int value = shopcar.get(id);
		shopcar.put(id, ++value);
		
		//3.返回响应
		resp.sendRedirect(req.getContextPath()+"/mng/shop/list");
	}

}
