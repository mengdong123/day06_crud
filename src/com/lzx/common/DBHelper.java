package com.lzx.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

/**
 * 数据库操作公共类
 * @author liqingkun7
 *
 */
public class DBHelper {
	private  static  Properties  ps  = new Properties();
	
	static{
	 InputStream is = 	Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconfig.properties");
	  try {
		ps.load(is);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	
	/**
	 * 创建数据库链接 
	 * @return
	 */
	public  static  Connection getConnection(){
		 Connection conn = null;
		//1、加载数据库驱动
		try {
			Class.forName(ps.getProperty("driver"));
			//2、提供连接参数
			String  username=ps.getProperty("username");
			String	password=ps.getProperty("password");
		    String	url=ps.getProperty("url");
		    //3、创建数据库连接   
		   conn=  (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void  closeConnection(java.sql.Connection conn){
		
		 //7、关闭JDBC
		   if(conn!=null)
		   {
			   try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	}
	
	
}
