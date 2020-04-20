package com.lzx.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 带缓存Dao工厂类，用于创建DaoImpl对象
 * 
 * @author liqingkun7
 *
 */
public class DaoFactory {

	private static Properties prop = new Properties();
	
	// 对象缓存容器
	private static Map<String, Object> objectCase = Collections.synchronizedMap(new HashMap<>());

	static {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
			prop.load(is);
		} catch (IOException e) {
			System.out.println("未到找dao.properties文件!!");
			e.printStackTrace();
		}
	}

	private DaoFactory() {

	}

	/**
	 * 通过反射机制，根据全限定名，获取对象 dao,properties
	 * 
	 * @param daoName
	 * @return
	 */
	public static Object getInstance(String daoName) {
		// 查找objectCase中是否已经包含有该对象
		Object obj = objectCase.get(daoName);
		if (obj == null) {// 创建新对象
			try {
				// 根据daoImpl的全限定名，获取clazz对象
				Class clazz = Class.forName(prop.getProperty(daoName));
				// 根据clazz全限定名，加载字节码成为一个对象
				obj = clazz.newInstance();
				objectCase.put(daoName, obj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

}
