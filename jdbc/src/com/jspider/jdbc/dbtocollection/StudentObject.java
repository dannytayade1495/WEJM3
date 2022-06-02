package com.jspider.jdbc.dbtocollection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentObject {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties = new Properties();
	private static List<Students> studentsList = new ArrayList<Students>();

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			fileReader = new FileReader("D:\\WEJM3\\jdbc\\resources\\DbProperties.properties");
			properties.load(fileReader);
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties.getProperty("user"),
					properties.getProperty("password"));
			statement = connection.createStatement();
			resultSet = statement.executeQuery(properties.getProperty("query"));
			while (resultSet.next()) {
				Students students = new Students();
				students.setStudentId(resultSet.getInt(1));
				students.setStudentName(resultSet.getString(2));
				students.setEmailId(resultSet.getString(3));
				students.setPhoneNumber(resultSet.getLong(4));
				students.setAddress(resultSet.getString(5));
//				System.out.println(students);
				studentsList.add(students);
			}
//			System.out.println(studentsList);
			for (Object obj : studentsList) {
				System.out.println(obj);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
