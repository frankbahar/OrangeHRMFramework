
package com.Orangehrm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
	private static Connection conn;
	private static Statement statement;
	private static ResultSet rs;

	/**
	 * Method will establish connection with Database
	 */

	public static void createConnection() {

		try {
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method will return data from Database in a List<Map>
	 * @param sql
	 * @return List<Map<String, String>>
	 */
	public static List<Map<String, String>> getResultSetData(String sql) {
		List<Map<String, String>> rsList = new ArrayList<>();
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			Map<String, String> rsMap;
			while (rs.next()) {
				rsMap = new LinkedHashMap<>();
				for(int i=1; i<=rsMetaData.getColumnCount(); i++) {
					rsMap.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
				}
				rsList.add(rsMap);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsList;
	}
	
	/**
	 * Method will close all db connections/resources
	 */
	public static void closeConnection() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
