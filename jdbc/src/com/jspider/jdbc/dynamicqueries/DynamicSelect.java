package com.jspider.jdbc.dynamicqueries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class DynamicSelect {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static FileReader file;
	private static Properties properties;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			file = new FileReader("D:\\WEJM3\\jdbc\\resources\\DbProperties.properties");
			properties = new Properties();
			properties.load(file);
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties.getProperty("user"), properties.getProperty("password"));
			preparedStatement = connection.prepareStatement(properties.getProperty("query"));
			System.out.println("Please enter a number: ");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getString(5));
				System.out.println();
			}
			preparedStatement = connection.prepareStatement(properties.getProperty("query9"));
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "ABC");
			preparedStatement.setString(3, "abc@xyz.com");
			preparedStatement.setLong(4, 9867541204L);
			preparedStatement.setString(5, "Pune");
			int resultInt = preparedStatement.executeUpdate();
			System.out.println(resultInt + " row(s) inserted. ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
