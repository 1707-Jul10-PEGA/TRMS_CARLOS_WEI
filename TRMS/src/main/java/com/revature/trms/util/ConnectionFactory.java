package com.revature.trms.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cFactory = null;
	private static Boolean build = true;

	private ConnectionFactory() {
		
	}
	public static synchronized ConnectionFactory getInstance() {
		if(build) {
			
			cFactory = new ConnectionFactory();
		}
		
		return cFactory;
	}
	public Connection getConnection() {

		Connection connection = null;

		Properties properties = new Properties();
		
		String path = "/Users/carlosgastelum/Documents/Revature/TRMS_CARLOS_WEI/TRMS/data.properties";
		try {
			properties.load(new FileReader(path));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}
}
