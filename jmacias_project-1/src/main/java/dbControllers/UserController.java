package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Employee;
import beans.Manager;
import beans.User;
import dataAccessObjects.UserDAO;
import service.ConnectionFactory;

public class UserController implements UserDAO {

	@Override
	public void logIn(int usrId, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logOut(int usrId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User createUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT pword, security_q, security_a, ismanager"
					+ " FROM Employee"
					+ " Where usr_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			
			// execute query
			ResultSet results = stmt.executeQuery();
			System.out.println(results);
			
			// iterate through results and return 
			User user = null;
			while (results.next()) {
				
				String password = results.getString("pword");
				String securityQ = results.getString("security_q");
				String securityA = results.getString("security_a");
				String isManager = results.getString("ismanager");
				System.out.println(password + " " + securityQ + " " + securityA + " " + isManager);
				if (isManager.equals("t")) {
					
					user = new Manager(userId, password, securityQ, securityA);
					System.out.println(user.getSecurityQ());
					
				}
				else {
					user = new Employee(userId, password, securityQ, securityA);
				}
				
				
			}
			return user;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the user from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
