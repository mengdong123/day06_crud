package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.lzx.common.DaoFactory;
/**
 * ��֤��¼ҳ��
 * @author 51019
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		
		//2.ִ��ҵ���߼�
		String rs = "null";
		 //1)�ж���֤���Ƿ�������ȷ
		 //��ȡ���ɵ���֤��
		 HttpSession session = req.getSession();
		 String cs = (String)session.getAttribute("vcs");
		 if(cs.equalsIgnoreCase(req.getParameter("cc"))) {//���Ӵ�Сд�ж�
	     //�ж��û���������
			 ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
			 Manager manager = managerDao.login(req.getParameter("lname"),req.getParameter("pwd"));
			 if(manager!=null) {
				 session.setAttribute("curr_mrg", manager);
				 resp.sendRedirect(req.getContextPath()+"/mng/home/home.jsp");
				 //�û�����������ȷ
				
				return;
			 }else{
				 //����
				 rs = "用户名密码输入错误，请重新输入";
			 }
		 }else {
			     rs =  "验证码输入错误";  
		 }
		//3.������Ӧ
		 req.setAttribute("msg", rs);
		 req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
