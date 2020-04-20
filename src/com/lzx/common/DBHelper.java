package com.lzx.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

/**
 * ���ݿ����������
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
	 * �������ݿ����� 
	 * @return
	 */
	public  static  Connection getConnection(){
		 Connection conn = null;
		//1���������ݿ�����
		try {
			Class.forName(ps.getProperty("driver"));
			//2���ṩ���Ӳ���
			String  username=ps.getProperty("username");
			String	password=ps.getProperty("password");
		    String	url=ps.getProperty("url");
		    //3���������ݿ�����   
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
	 * �ر����ݿ�����
	 * @param conn
	 */
	public static void  closeConnection(java.sql.Connection conn){
		
		 //7���ر�JDBC
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
