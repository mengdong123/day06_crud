package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.entity.Manager;
/*
 * ��½������
 */
@WebFilter("/mng/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//�鿴�Ƿ��¼
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session =   req.getSession();
		Manager man = (Manager) session.getAttribute("curr_mrg");
		
		//�����¼�ͷ���
		if(man!=null) {
			chain.doFilter(request, response);
		}else {
			//û��½ת�ص�½ҳ��
			req.setAttribute("msg", "���ȵ�¼");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
