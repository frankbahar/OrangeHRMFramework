package com.Orangegrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:ORCL";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

	// @Test
	public void dbConnection() throws SQLException {
		// creating connection
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		// create a statement
		Statement statement = conn.createStatement();
		// execute Query and store results from database in ResultSet object
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Countries");
		// get values from resultSet
		resultSet.next();
		String columnData = resultSet.getString("Country_Name");
		System.out.println(columnData);

		resultSet.next();
		columnData = resultSet.getString("Country_Name");
		System.out.println(columnData);

		System.out.println("---Printing values using loop---");
		while (resultSet.next()) {
			columnData = resultSet.getString("Country_Name");
			System.out.println(columnData);
		}

		// display in console department id & department name in 1 row

		// close all db connection
		resultSet.close();
		statement.close();
		conn.close();
	}

//	@Test
	public void listDepartmentInfo() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT department_id, department_name FROM Departments");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
		}

		resultSet.close();
		statement.close();
		conn.close();
	}
}