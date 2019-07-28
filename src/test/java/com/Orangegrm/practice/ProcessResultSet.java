package com.Orangegrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProcessResultSet {
	String dbURL = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:ORCL";
	String dbUsername = "Syntax";
	String dbPassword = "syntax123";

	//@Test
	public void getResultSetData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT first_name, last_name FROM Employees WHERE job_id ='IT_PROG'");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colNum = rsMetaData.getColumnCount();
	
		List<Map<String, String>> rsList = new ArrayList<>();
		Map<String, String> rsMap = new HashMap<>();
		while(rs.next()) {
			rsMap = new HashMap<>();
			rsMap.put("first_name", rs.getString("first_name"));
			rsMap.put("last_name", rs.getString("last_name"));
			rsList.add(rsMap); 
		}	
		//print all column names
		System.out.println(rsList);
		rs.close();
		st.close();
		conn.close();
	}
	
	//@Test
	public void review() {
		Map<String, String> map = new HashMap<>();
		map.put("first_name", "Alexander");
		map.put("first_name", "John");
		map.put("first_name", "David");
		System.out.println(map.size());//1
		System.out.println(map); // David
		
	}
	
	//@Test
	public void listAddress() throws SQLException {
		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT l.street_address,l.city, c.country_name FROM Locations l" + 
				" JOIN Countries c ON l.country_id = c.country_id");
		List<Map<String, String>> rl = new ArrayList<>();
		Map<String, String> rm;
		while(rs.next()) {
			rm = new HashMap<>();
			rm.put("Street Address", rs.getString(1));
			rm.put("City", rs.getString(2));
			rm.put("Country Name", rs.getString(3));
			rl.add(rm);
		}
		for(Map<String, String> map: rl) {
			System.out.print(map.get("Street Address") + " " + map.get("City") + " " + map.get("Country Name") +"\n");
		}
		
		rs.close();
		st.close();
		conn.close();
	}
	

	@Test
	public void listAllColumns() throws SQLException {
		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Jobs");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String, String>> rl = new ArrayList<>();
		Map<String, String> rm;
		while(rs.next()) {
			rm = new HashMap<>();
			for(int i = 1; i<=rsMetaData.getColumnCount(); i++) {
				rm.put(rsMetaData.getColumnName(i), rs.getString(i));
			}
			rl.add(rm);
			
		}
		for(Map<String, String> map: rl) {
			for(int i = 1; i<=rsMetaData.getColumnCount(); i++) {
				System.out.print(map.get(rsMetaData.getColumnName(i)) + " ");
			}
			System.out.println();
		}
		
		rs.close();
		st.close();
		conn.close();
	}

}


