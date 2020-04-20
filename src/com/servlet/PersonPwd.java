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
 * �޸�����
 * 
 * @author 51019
 *
 */
@WebServlet("/mng/person/pwd")
public class PersonPwd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ��������
		 //�õ���¼�û�
		HttpSession session = req.getSession();
		Manager man = (Manager)session.getAttribute("curr_mrg");
		 //�õ���������
		String old_pwd = req.getParameter("old_pwd");
		String new_pwd = req.getParameter("new_pwd");
		String again_pwd = req.getParameter("again_pwd");
		//2.ִ��ҵ���߼�
		String mes = "";
		//�ж�����ľ������Ƿ�������ȷ
		if(man.getPwd().equals(old_pwd)) {
			//�ж������������Ƿ�����һ��
			if(new_pwd.equals(again_pwd)) {
			   //�������뱣�������ݿ�
		         ManagerDao managerDao = (ManagerDao)DaoFactory.getInstance("managerDao");
		         man.setPwd(new_pwd);
		         managerDao.update(man);
		         mes = "�����޸ĳɹ��������µ�¼";
		         req.setAttribute("msg",mes);	 
				 req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}else {
				mes = "�����������벻һ�£�����������";
				req.setAttribute("mes", mes);
				req.getRequestDispatcher("/mng/person/pwd.jsp").forward(req, resp);
			}
		}else {
			mes = "�����������������������";
			req.setAttribute("mes", mes);
			req.getRequestDispatcher("/mng/person/pwd.jsp").forward(req, resp);	
		}
		
		
		
		//3.������Ӧ
	}

}
