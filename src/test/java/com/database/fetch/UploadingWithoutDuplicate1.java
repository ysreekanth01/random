package com.database.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class UploadingWithoutDuplicate1 {

	public static void main(String[] args) throws SQLException {
		
		String mobileNumber1="ip=20";
		String price1="300000";
		String mobileName1="iphonee";
		
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root", "root");
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery("Select * from mobile; ");
		
		List<String> list=new ArrayList<String>();
		while(result.next()) {
			
			
		}
		
		
		
			statement.executeUpdate("insert into mobile values('ip15',200000,'iphone');");
		}
	}


