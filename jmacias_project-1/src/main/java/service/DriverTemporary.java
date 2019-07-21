package service;


import beans.ReimbRequest;
import dataAccessObjects.ReimbRequestDAO;
import dataAccessObjects.UserDAO;
import dbControllers.ReimbRequestController;
import dbControllers.UserController;

public class DriverTemporary {
	public static UserDAO uDao = new UserController();
	public static ReimbRequestDAO rDAO = new ReimbRequestController();

	public static void main(String[] args) {
		
		ReimbRequest request = new ReimbRequest();
		request = rDAO.addNewRequest(3, 99.95, "Food processor");
		System.out.println("id = " + request.getId());

	}

}
