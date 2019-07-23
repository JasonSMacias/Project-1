package dbControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.ReimbRequest;
import dataAccessObjects.ReimbRequestDAO;
import service.ConnectionFactory;

public class ReimbRequestController implements ReimbRequestDAO {

	@Override
	public ReimbRequest addNewRequest(int employeeId, double value, String description) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			
			String sql = "INSERT INTO ReimbReq(emp_id, value, description, date_requested, status)"
					+ " VALUES (?, ?, ?, ?, ?)";
			String[] primaryKeys = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
			stmt.setInt(1, employeeId);
			stmt.setDouble(2, value);
			stmt.setString(3, description);
			LocalDate date = LocalDate.now( ZoneId.of( "America/New_York" ) );
			System.out.println(date);
			stmt.setObject(4, java.sql.Date.valueOf(date));
			stmt.setString(5, "pending");
			
			// Execute
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows inserted: " + rowsAffected);
			
			ReimbRequest savedRequest = new ReimbRequest(employeeId, value, description, date, "pending");
			
			ResultSet resultSet = stmt.getGeneratedKeys();
			while(resultSet.next()) {
				savedRequest.setId(resultSet.getInt(1));;
			}
			return savedRequest;
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
	public ReimbRequest addNewRequest(int employeeId, double value, String description, String image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbRequest viewRequest(int reqId) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT emp_id, value, description, date_requested, status"
					+ " FROM ReimbReq"
					+ " Where req_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reqId);
			
			// execute query
			ResultSet results = stmt.executeQuery();
			
			
			// iterate through results and return 
			ReimbRequest request = null;
			while (results.next()) {
				
				int empId = results.getInt("emp_id");
				double value = results.getDouble("value");
				String description = results.getString("description");
				Date sqlDate = results.getDate("date_requested");
				LocalDate date = ((java.sql.Date) sqlDate).toLocalDate();
				String status = results.getString("status");
					
				request = new ReimbRequest(reqId, empId, value, description, date, status);
	
			}
			return request;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the request from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public List<ReimbRequest> viewRequestsByEmployee(int empId) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT req_id, emp_id, value, description, date_requested, status"
					+ " FROM ReimbReq";
			Statement stmt = conn.createStatement();
			// execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);
			
			// iterate through results and return 
			List<ReimbRequest> requests = new ArrayList<>();
			while (results.next()) {
				int reqId = results.getInt("req_id");
				double value = results.getDouble("value");
				String description = results.getString("description");
				Date sqlDate = results.getDate("date_requested");
				LocalDate date = ((java.sql.Date) sqlDate).toLocalDate();
				String status = results.getString("status");
				ReimbRequest request = new ReimbRequest(reqId, empId, value, description, date, status);
				if (empId == results.getInt("emp_id")) {
					requests.add(request);
				}
			}
			
			return requests;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the requests from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public List<ReimbRequest> viewRequestsByEmployee(int empId, String status) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT req_id, emp_id, value, description, date_requested, status"
					+ " FROM ReimbReq";
			Statement stmt = conn.createStatement();
			// execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);
			
			// iterate through results and return 
			List<ReimbRequest> requests = new ArrayList<>();
			while (results.next()) {
				int reqId = results.getInt("req_id");
				double value = results.getDouble("value");
				String description = results.getString("description");
				Date sqlDate = results.getDate("date_requested");
				LocalDate date = ((java.sql.Date) sqlDate).toLocalDate();
				String status2 = results.getString("status");
				ReimbRequest request = new ReimbRequest(reqId, empId, value, description, date, status2);
				if (empId == results.getInt("emp_id") && status.equals(status2)) {
					requests.add(request);
				}
			}
			
			return requests;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the requests from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public List<ReimbRequest> viewRequests() {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT req_id, emp_id, value, description, date_requested, status"
					+ " FROM ReimbReq";
			Statement stmt = conn.createStatement();
			// execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);
			
			// iterate through results and return 
			List<ReimbRequest> requests = new ArrayList<>();
			while (results.next()) {
				int reqId = results.getInt("req_id");
				int empId = results.getInt("emp_id");
				double value = results.getDouble("value");
				String description = results.getString("description");
				Date sqlDate = results.getDate("date_requested");
				LocalDate date = ((java.sql.Date) sqlDate).toLocalDate();
				String status = results.getString("status");
				ReimbRequest request = new ReimbRequest(reqId, empId, value, description, date, status);
				requests.add(request);
			}
			
			return requests;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the requests from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public List<ReimbRequest> viewRequests(String status) {
		// connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
			// statement
			String sql = "SELECT req_id, emp_id, value, description, date_requested, status"
					+ " FROM ReimbReq";
			Statement stmt = conn.createStatement();
			// execute query
			ResultSet results = stmt.executeQuery(sql);
			System.out.println(results);
			
			// iterate through results and return 
			List<ReimbRequest> requests = new ArrayList<>();
			while (results.next()) {
				int reqId = results.getInt("req_id");
				int empId = results.getInt("emp_id");
				double value = results.getDouble("value");
				String description = results.getString("description");
				Date sqlDate = results.getDate("date_requested");
				LocalDate date = ((java.sql.Date) sqlDate).toLocalDate();
				String status2 = results.getString("status");
				ReimbRequest request = new ReimbRequest(reqId, empId, value, description, date, status);
				if (status.equals(status2)) {
					requests.add(request);
				}				
			}
			
			return requests;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with retrieving the requests from the db.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
			return null;
		}
	}

	@Override
	public void resolvePending(int reimbId, int resolvedBy) {
		// Connection
		try (Connection conn = ConnectionFactory.getConnectionUsingProp()) {
					
					// Statement
					String sql = "Update Reimbreq "
							+ "SET status = 'resolved', resolvedby = ?"
							+ " Where req_id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, resolvedBy);
			stmt.setInt(2, reimbId);
			
			// 3. Execute
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows insterted: " + rowsAffected);
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong with updating db.");
			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problem with getting prop for connection.");
		}
	}

	@Override
	public String addImage(int reimbId, String imageInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
