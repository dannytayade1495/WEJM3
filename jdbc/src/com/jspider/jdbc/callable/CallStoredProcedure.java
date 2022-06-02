package com.jspider.jdbc.callable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CallStoredProcedure {

	private static Connection connection;
	private static Statement statement;
	private static FileReader fileReader;
	private static Properties properties;

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		fileReader = new FileReader("D:\\WEJM3\\jdbc\\resources\\DbProperties.properties");
		properties = new Properties();
		properties.load(fileReader);
		connection = DriverManager.getConnection(properties.getProperty("dburl"), properties.getProperty("user"),
				properties.getProperty("password"));
		CallableStatement prepareCall = connection.prepareCall("call proc");
		ResultSet executeQuery = prepareCall.executeQuery();
		while (executeQuery.next()) {
			System.out.println(executeQuery.getInt("eid"));
			System.out.println(executeQuery.getString("ename"));
		}

	}
}
