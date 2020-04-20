package com.servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.ManagerDao;
import com.dao.ProductDao;
import com.entity.Manager;
import com.entity.Product;
import com.lzx.common.DaoFactory;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

@MultipartConfig
@WebServlet("/mng/pro/add")
public class ProductAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取请求数据
		ProductDao memberDao = (ProductDao) DaoFactory.getInstance("productDao");
		Product member = new Product();
		member.setName(req.getParameter("name"));
		// 文件上传
		// 获取文件
		Part part = req.getPart("thumbnail");
		// 获取真实路径
		String path = req.getRealPath("/image");
		File file = new File(path);
		// 判断 没有文件，创建文件
		if (!file.exists()) {
			file.mkdir();
		}
		// 上传
		part.write(path + "/" + part.getSubmittedFileName());
		member.setThumbnail(part.getSubmittedFileName());
		member.setInventory(Integer.parseInt(req.getParameter("inventory")));
		member.setSales_volume(Integer.parseInt(req.getParameter("sales_volume")));
		// 字符串转bigdecimal类型
		String _price = req.getParameter("price");
		if (_price != null) {
			BigDecimal price = new BigDecimal(_price);
			member.setPrice(price);
		}
		String _sale_price = req.getParameter("sale_price");
		if (_sale_price != null) {
			BigDecimal sale_price = new BigDecimal(_sale_price);
			member.setSale_price(sale_price);
		}
		member.setDetail_description(req.getParameter("detail_description"));
		member.setSelling_description(req.getParameter("selling_description"));

		// 字符串转日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date create_time = null;
		Date sale_time = null;
		try {
			create_time = sdf.parse(req.getParameter("create_time"));
			sale_time = sdf.parse(req.getParameter("sale_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		member.setCreate_time(create_time);
		member.setSale_time(sale_time);

		memberDao.save(member);
		// 3.返回请求数据
		resp.sendRedirect(req.getContextPath() + "/mng/pro/list?number=1&size=2");
	}
}
