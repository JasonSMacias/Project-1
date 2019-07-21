package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import dataAccessObjects.UserDAO;
import service.ConnectionFactory;

public class UserController implements UserDAO {

	

	@Override
	public Employee createUser(Employee newUser) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// 2. create the statement
			System.out.println(newUser);
			String sql = "INSERT INTO Employee(u_name, pword, security_q, security_a, ismanager)"
					+ " VALUES (?, ?, ?, ?, ?)";
			String[] primaryKeys = {"usr_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
			stmt.setString(1,  newUser.getName());
			stmt.setString(2, newUser.getpWord());
			stmt.setString(3, newUser.getSecurityQ());
			stmt.setString(4, newUser.getSecurityA());
			stmt.setBoolean(5, newUser.isManager());
			
			// Execute
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows inserted: " + rowsAffected);
			
			ResultSet resultSet = stmt.getGeneratedKeys();
			while(resultSet.next()) {
				newUser.setId(resultSet.getInt(1));
			}
			
			return newUser;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with creating employee in db.");
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}

	}

	@Override
	public Employee getUser(int userId) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT u_name, pword, security_q, security_a, ismanager"
					+ " FROM Employee"
					+ " Where usr_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			
			// execute query
			ResultSet results = stmt.executeQuery();
			System.out.println(results);
			
			// iterate through results and return 
			Employee user = null;
			while (results.next()) {
				
				String uName = results.getString("u_name");
				String password = results.getString("pword");
				String securityQ = results.getString("security_q");
				String securityA = results.getString("security_a");
				String isManager = results.getString("ismanager");
				System.out.println(uName + " " + password + " " + securityQ + " " + securityA + " " + isManager);
				if (isManager.equals("t")) {
					
					user = new Employee(uName, password, securityQ, securityA, true);
					System.out.println(user.getSecurityQ());
					
				}
				else {
					user = new Employee(uName, password, securityQ, securityA, false);
					
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
	public void logIn(int usrId, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logOut(int usrId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getUsers() {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT usr_id, u_name, pword, security_q, security_a, isManager"
					+ " FROM Employee";
			Statement stmt = conn.createStatement();
			
			// execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);
			
			// iterate through results and return 
			List<Employee> employees = new ArrayList<>();
			while (results.next()) {
				int userId = results.getInt("usr_id");
				String uName = results.getString("u_name");
				String password = results.getString("pword");
				String securityQ = results.getString("security_q");
				String securityA = results.getString("security_a");
				boolean isManager = results.getString("isManager") == "t" ? true : false;
				Employee employee = new Employee(userId, uName, password, securityQ, securityA, isManager);
				employees.add(employee);
			}
			
			return employees;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the cars from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public Employee updateUser(Employee updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int userId) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			//  statement
			String sql = "DELETE FROM Employee"
					+ " WHERE usr_id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			
			
			// Execute
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Employee deleted: " + rowsAffected);
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with creating car in db.");
			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
		}

	}


}