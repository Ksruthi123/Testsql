package net.codejava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class JavaMySQLTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter UserName:");
		String userName = reader.readLine();
		
		System.out.print("Enter Password:");
		String userPassword = reader.readLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 String url = "jdbc:mysql://localhost:3306/user?autoReconnect=true&useSSL=false";
	        String username = "root";
	        String password = "Admin@123";
	       System.out.println("Connected...");
       try {
		Connection connection = DriverManager.getConnection(url,username,password);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where users.UserName = '"+userName+"' AND users.Password = '"+userPassword+"'");

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnNumber = rsmd.getColumnCount();
		 if (rs.next()) {
			 for(int i=1; i<=columnNumber;i++) { 
				 String columnValue = rs.getString(i);
					 System.out.print(rsmd.getColumnName(i)+" "+columnValue);
				 System.out.println("");
			 }

		 } else { 
			 System.out.println("No records found. Please check your password");
		 }
		
	} catch (SQLException e) {
		System.out.println(e.toString());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
	}

}
