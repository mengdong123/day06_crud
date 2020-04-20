package com.listern;

import java.io.File;
import java.lang.reflect.InvocationHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * servletcontextlistern创建
 * @author 51019
 *
 */
@WebListener
public class MyServletContextListern implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//在applection中传入path路径
				ServletContext sc = sce.getServletContext();
				sc.setAttribute("path", sc.getContextPath());
			}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
