package com.jsp.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Creation {

	public static void main(String[] args) {
		FileReader filereader = null;
		Properties properties = new Properties();
		Connection connection = null;
		Statement statement = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the customer id");
		int custid = scan.nextInt();
//		System.out.println("Enter the customer name");
//		String custname = scan.next();
//		System.out.println("Enter the customer email");
//		String email = scan.nextLine();
//		System.out.println("Enter the customer password");
//		String password = scan.nextLine();
//		System.out.println("Enter the customer address");
//		String address = scan.nextLine();
//		System.out.println("Enter the customer state");
//		String state = scan.nextLine();
//		System.out.println("Enter the customer city");
//		String city = scan.nextLine();
//		System.out.println("Enter the pincode");
//		int pincode = scan.nextInt();
//		System.out.println("Enter the phone number");
//		String phone = scan.next();
//		
	
		String query = "delete from custinfo where custid = "+custid+"";
				//"update custinfo set custname = '"+custname+"' where custid = "+custid+"";
				//"insert into custinfo(custname,email,password,address,state,city,pincode,phone) values ('"+custname+"','"+email+"','"+password+"','"+address+"','"+state+"','"+city+"',"+pincode+",'"+phone+"')";
				//"create table custinfo(custid integer auto_increment primary key,custname varchar(20),email varchar(20) unique,password varchar(20), address varchar(50),state varchar(20),city varchar(20),pincode integer(10),phone varchar(20) unique)";
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
//			int updateCount = statement.getUpdateCount();
//			System.out.println("No of rows affected: " + updateCount);
			
			int updateCount =statement.executeUpdate(query);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
