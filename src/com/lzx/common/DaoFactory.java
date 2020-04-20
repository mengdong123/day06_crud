package com.lzx.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ������Dao�����࣬���ڴ���DaoImpl����
 * 
 * @author liqingkun7
 *
 */
public class DaoFactory {

	private static Properties prop = new Properties();
	
	// ���󻺴�����
	private static Map<String, Object> objectCase = Collections.synchronizedMap(new HashMap<>());

	static {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
			prop.load(is);
		} catch (IOException e) {
			System.out.println("δ����dao.properties�ļ�!!");
			e.printStackTrace();
		}
	}

	private DaoFactory() {

	}

	/**
	 * ͨ��������ƣ�����ȫ�޶�������ȡ���� dao,properties
	 * 
	 * @param daoName
	 * @return
	 */
	public static Object getInstance(String daoName) {
		// ����objectCase���Ƿ��Ѿ������иö���
		Object obj = objectCase.get(daoName);
		if (obj == null) {// �����¶���
			try {
				// ����daoImpl��ȫ�޶�������ȡclazz����
				Class clazz = Class.forName(prop.getProperty(daoName));
				// ����clazzȫ�޶����������ֽ����Ϊһ������
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
