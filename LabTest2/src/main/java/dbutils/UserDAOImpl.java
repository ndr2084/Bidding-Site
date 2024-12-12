package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ServiceData;

public class UserDAOImpl implements UserDAO{

	private static final String DB_URL = "jdbc:sqlite:test3_database.db";
	static {
        try {
            Class.forName("org.sqlite.JDBC"); // Explicitly load the SQLite driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load SQLite JDBC driver", e);
        }
    }
	@Override
	public ServiceData getUserByProfile(String email, String password) {
		String query = "SELECT * FROM User WHERE email = ? AND password= ?"; 
        
		try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println("cum");

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	ServiceData user = new ServiceData(); 
            	user.setField1(resultSet.getString(1));
                user.setField2(resultSet.getString(2));
                if(resultSet.getString(1) == null || resultSet.getString(2) == null) {
                	return null;
                }
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
		return null; 
	}
	@Override
	public int addUser(String firstName, String lastName, String email, String password) {
		String query =  "INSERT INTO User (firstName, lastName, email, password)  VALUES (?, ?, ?, ?)";
		
		//Insert into db
		 try (Connection connection = DriverManager.getConnection(DB_URL);
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 
			 preparedStatement.setString(1, firstName);
	         preparedStatement.setString(2, lastName);
	         preparedStatement.setString(3, email);
	         preparedStatement.setString(4, password);
	         
	         int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("User inserted successfully!");
	            }
	            
		 } catch(SQLException e) { 
			 System.out.println("Database error: " + e.getErrorCode());
		 }
		return 0;
	}
	

}
