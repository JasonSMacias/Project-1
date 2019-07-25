package service;

import beans.Employee;
import dataAccessObjects.ReimbRequestDAO;
import dataAccessObjects.UserDAO;
import dbControllers.ReimbRequestController;
import dbControllers.UserController;

public class SignupService {
	private static UserDAO uDao = new UserController();
	private static ReimbRequestDAO rDAO = new ReimbRequestController();
	
	public static Employee signupUser(String name, String password, String securityQ, String securityA, String role) {
		Employee createdEmployee = new Employee(name, password, securityQ, securityA, (role.equals("Manager") ? true : false));
		Employee returnedEmployee = uDao.createUser(createdEmployee);
		
//		uDao.createUser(newEmployee)
		return returnedEmployee;
	}
}
