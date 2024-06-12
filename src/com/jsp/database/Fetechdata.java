package com.jsp.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Fetechdata {

	public static void main(String[] args) {
		FileReader filereader = null;
		Properties properties = new Properties();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the customer id");
		int custid = scan.nextInt();
		String query = "select * from custinfo where custid="+custid+"";
		//and email='"+email+"' and phone='"+phone+"'
		try {
			filereader = new FileReader("config/dbconfig.properties");
            properties.load(filereader);
			
			Class.forName(properties.getProperty("Driver"));
			System.out.println("load and register the driver");
			
			connection = DriverManager.getConnection(properties.getProperty("url"), 
					properties.getProperty("username"),
					properties.getProperty("password"));
			System.out.println("Establish the connection");
			
			statement = connection.createStatement();
			System.out.println("execute the statement");
			
//			boolean res = statement.execute(query);
//			System.out.println(res);
//			
//			resultset = statement.getResultSet();
			
			resultset  = statement.executeQuery(query);
			
			if(resultset.next())
			{
				System.out.println(resultset.getInt("custid"));
				System.out.println(resultset.getString("custname"));
				System.out.println(resultset.getString("email"));
				System.out.println(resultset.getString("password"));
				System.out.println(resultset.getString("address"));
				System.out.println(resultset.getString("state"));
				System.out.println(resultset.getString("city"));
				System.out.println(resultset.getInt("pincode"));
				System.out.println(resultset.getString("phone"));
				
			}
			else
			{
				System.out.println("invalid option");
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
