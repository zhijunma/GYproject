package com.it.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 
 * 
* <p>
 * Title:
 * 
 *��ȡgetConnection
 * </p>
 * <p>
 * Description:com.it.utils.JDBCUtils.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018��8��20�� ����9:30:23
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public class JDBCUtils {
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	/*
	 * �������ӳ�BasicDataSource
	 */
	static BasicDataSource dataSource = new BasicDataSource();
	
	//��̬�����
	static {
		try {
			readConfig();
			//����4��
			//�����ӳض��� ���л���������
			dataSource.setDriverClassName(driverClassName);
			//ָ��Ҫ���ӵ����ݿ��ַ
			dataSource.setUrl(url);
			//ָ��Ҫ�������ݵ��û���
			dataSource.setUsername(username);
			//ָ��Ҫ�������ݵ��û���
			dataSource.setPassword(password);
			//����ѡ��
			//��ʼ������
			dataSource.setInitialSize(10);
			//�����������
			dataSource.setMaxActive(8);
			//����������
			dataSource.setMaxIdle(5);
			//��С��������
			dataSource.setMinIdle(3);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void readConfig()throws Exception{
		InputStream in = JDBCUtils .class.getClassLoader().getResourceAsStream("db.properties");

		Properties pro = new Properties();
		 pro.load(in);
		 driverClassName =pro.getProperty("driverClass");
		 url = pro.getProperty("url");
		 username = pro.getProperty("username");
		 password = pro.getProperty("password");
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	/*
	 * ��ȡ����
	 */
	public static Connection getConnections(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
