package service;


import beans.Employee;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;

public class DriverTemporary {
	public static UserDAO uDao = new UserController();

	public static void main(String[] args) {
		//testing create user
		Employee user = new Employee("Peter", "pass2", "Test question2?", "Test answer3", false);
		uDao.createUser(user);
		System.out.println(user);
		
		// deleting user
		uDao.removeUser(47);

	}

}
