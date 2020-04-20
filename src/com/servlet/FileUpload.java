package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
   * �ļ��ϴ�
 * @author 51019
 *
 */
@WebServlet("/fileupload")
public class FileUpload extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		Collection<Part> coll = req.getParts();
		//2.ִ��ҵ���߼�
		// �ж�·��
		String path =  req.getRealPath("/image");
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		//�������ļ���
		for(Part part : coll) {
			part.write(path+"/"+part.getSubmittedFileName());
		}
		//3.������Ӧ
		resp.sendRedirect(req.getContextPath()+"/upload/FileUpload.jsp");
	}

}
