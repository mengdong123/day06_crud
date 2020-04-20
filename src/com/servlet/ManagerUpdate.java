package com.servlet;

import java.io.File;
import java.io.IOException;
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
import com.entity.Manager;
import com.lzx.common.DaoFactory;
/**
 * 管理员更新
 * @author 51019
 *
 */
@MultipartConfig
@WebServlet("/mng/man/update")
public class ManagerUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		
		//2.执行业务逻辑
		ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date joined_date = null;
		Date create = null;
		try {
			joined_date = (Date) sdf.parse(req.getParameter("joined_date"));
			create = (Date) sdf.parse(req.getParameter("create_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Manager man = managerDao.findOne(Integer.parseInt(id));
		man.setLname(req.getParameter("lname"));
		man.setPwd(req.getParameter("pwd"));
		man.setReal_name(req.getParameter("real_name"));
		man.setSalt(req.getParameter("salt"));
		man.setEmail(req.getParameter("email"));
		man.setJoined_date(joined_date);
		
		String status = new String("status"+id);
		if(req.getParameter("status")!="") {
			man.setStatus(Integer.parseInt(req.getParameter(status)));
		}
		//文件上传
		//获取文件
		Part part = req.getPart("avatar");
		// 获取真实路径
				String path = req.getRealPath("/image");
				// 判断有无文件，没有则创建
				File file = new File(path);
				if (!file.exists()) {
					file.mkdir();
				}
				// 把文件写出来
				System.out.println(path.toString());
		//把文件写到路径中
		part.write(path+"/"+part.getSubmittedFileName());
		//获取文件名字，把文件名字上传到数据库
		String avatar = part.getSubmittedFileName();
		man.setAvatar(avatar);
		man.setTel(req.getParameter("tel"));
		man.setMemo(req.getParameter("memo"));
		man.setCreate_time(create);
		managerDao.update(man);
		//3.返回响应
		resp.sendRedirect(req.getContextPath()+"/mng/man/list?number=1&size=2");
	}
}
