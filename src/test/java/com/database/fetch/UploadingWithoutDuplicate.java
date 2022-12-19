package com.database.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class UploadingWithoutDuplicate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
	
				String mobileName="galaxyM32";
				String price="19000";
				String brandName="samsung";
					
					
					Driver dbdriver=new Driver();
					DriverManager.registerDriver(dbdriver);
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44","root","root");
					try {
					 Statement statement = connection.createStatement();	
					 ResultSet result = statement.executeQuery("select * from mobile");
					List<String> list=new ArrayList<String>();
					while(result.next()) {
						list.add(result.getString("mobileName")+" || "+result.getString("price")+" || "+result.getString("brandName"));
					}
						if((list.contains(mobileName+" || "+price+" || "+brandName))) {
						System.out.println("Data already exists");
					}
					
			        else {
					    statement.executeUpdate("insert into mobile values('"+mobileName+"','"+price+"','"+brandName+"');");
						System.out.println("Data Updated Successfully");
					  }
					}
					finally {
						connection.close();
					}

			}
			


	}


