package com.servlet;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.NewsDao;
import com.entity.News;
import com.lzx.common.DaoFactory;
@WebServlet("/mng/news/add")
public class NewsAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.��ȡ������Դ
		News news = new News();
		news.setTitle(req.getParameter("title"));
		

		// �ļ��ϴ�
		// ��ȡ�ļ�
		Part part = req.getPart("thumbnail");
		// ��ȡ��ʵ·��
		String path = req.getRealPath("/image");
		// �ж������ļ���û���򴴽�
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		// ���ļ�д����
		// ���ļ�д��·����
		part.write(path + "/" + part.getSubmittedFileName());
		// ��ȡ�ļ����֣����ļ������ϴ������ݿ�
		String thumbnail = part.getSubmittedFileName();
		news.setThumbnail(thumbnail);
		news.setContent(req.getParameter("content"));
		news.setHits(Integer.parseInt(req.getParameter("hits")));
		news.setTop(Integer.parseInt(req.getParameter("top")));
		
		SimpleDateFormat sdf =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(req.getParameter("pub_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		news.setPub_time(date);
		
		//2.ִ��ҵ���߼�
		NewsDao newsDao = (NewsDao) DaoFactory.getInstance("newsDao");
		newsDao.save(news);
		
	   resp.sendRedirect(req.getContextPath()+"/mng/news/list?number=1&size=2");
		
	}
}
