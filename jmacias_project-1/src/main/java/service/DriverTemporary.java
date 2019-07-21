package service;


import beans.Employee;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;

public class DriverTemporary {
	public static UserDAO uDao = new UserController();

	public static void main(String[] args) {
		//testing create user
		Employee user = new Employee("Helen", "pass2", "Test question2?", "Test answer3", true);
		uDao.createUser(user);
		System.out.println(user);
		
		user.setName("Bertha");
		uDao.updateUser(user, "name");
		
		
		// deleting user
//		uDao.removeUser(47);

	}

}
