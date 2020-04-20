package com.servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
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

import com.dao.ProductDao;
import com.entity.Product;
import com.lzx.common.DaoFactory;

/**
 * 商品更新
 * 
 * @author 51019
 *
 */

@MultipartConfig
@WebServlet("/mng/pro/update")
public class ProductUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取请求数据

		// 2.执行业务逻辑
		ProductDao productDao = (ProductDao) DaoFactory.getInstance("productDao");
		Product member = productDao.findOne(Integer.parseInt(req.getParameter("id")));
		member.setName(req.getParameter("name"));
		// 文件上传
		Part part = req.getPart("thumbnail");
		// 获取真实路径
		String path = req.getRealPath("/image");
		// 判断有无文件，没有则创建
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		// 把文件写出来
		part.write(path + "/" + part.getSubmittedFileName());
		// 获取文件名字，把文件名保存到表中
		String thumbnail = part.getSubmittedFileName();
		member.setThumbnail(thumbnail);
		member.setInventory(Integer.parseInt(req.getParameter("inventory")));
		member.setSales_volume(Integer.parseInt(req.getParameter("sales_volume")));
		// 字符串转bigdecimal类型
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		member.setPrice(price);
		BigDecimal sale_price = new BigDecimal(req.getParameter("sale_price"));
		member.setSale_price(sale_price);

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

		productDao.update(member);
		// 3.返回响应
		resp.sendRedirect(req.getContextPath() + "/mng/pro/list?number=1&size=2");
	}

}
