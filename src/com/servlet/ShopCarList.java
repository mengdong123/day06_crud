package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.entity.Product;
import com.lzx.common.DaoFactory;

@WebServlet("/mng/shop/list")
public class ShopCarList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao productDao = (ProductDao)DaoFactory.getInstance("productDao");
		//从session获取购物车
		HttpSession session =  req.getSession();
		Map<String,Integer> shopcar = (Map<String, Integer>) session.getAttribute("shopcaradd");
		//从购物车获取id
		
		if(shopcar!=null) {
		
		Map<Product,Integer> shoplist = new HashMap<>();
		for (Map.Entry<String, Integer> s : shopcar.entrySet() ){
			
			Product product = productDao.findOne(Integer.parseInt(s.getKey()));
			
			shoplist.put(product,s.getValue());
		}	
        
		req.setAttribute("shoplist",shoplist);
		
		}
		req.getRequestDispatcher("/mng/shopcar/list.jsp").forward(req, resp);
		
		
	}

}
