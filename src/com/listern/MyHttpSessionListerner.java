package com.listern;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 *»á»°¼àÌý
 * @author 51019
 *
 */
@WebListener
public class MyHttpSessionListerner implements HttpSessionListener{
	private int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setAttribute("count", ++count);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	
		
	}

	

}
