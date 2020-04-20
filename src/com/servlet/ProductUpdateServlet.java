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
 * ��Ʒ����
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
		// 1.��ȡ��������

		// 2.ִ��ҵ���߼�
		ProductDao productDao = (ProductDao) DaoFactory.getInstance("productDao");
		Product member = productDao.findOne(Integer.parseInt(req.getParameter("id")));
		member.setName(req.getParameter("name"));
		// �ļ��ϴ�
		Part part = req.getPart("thumbnail");
		// ��ȡ��ʵ·��
		String path = req.getRealPath("/image");
		// �ж������ļ���û���򴴽�
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		// ���ļ�д����
		part.write(path + "/" + part.getSubmittedFileName());
		// ��ȡ�ļ����֣����ļ������浽����
		String thumbnail = part.getSubmittedFileName();
		member.setThumbnail(thumbnail);
		member.setInventory(Integer.parseInt(req.getParameter("inventory")));
		member.setSales_volume(Integer.parseInt(req.getParameter("sales_volume")));
		// �ַ���תbigdecimal����
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		member.setPrice(price);
		BigDecimal sale_price = new BigDecimal(req.getParameter("sale_price"));
		member.setSale_price(sale_price);

		member.setDetail_description(req.getParameter("detail_description"));
		member.setSelling_description(req.getParameter("selling_description"));

		// �ַ���ת����
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
		// 3.������Ӧ
		resp.sendRedirect(req.getContextPath() + "/mng/pro/list?number=1&size=2");
	}

}
