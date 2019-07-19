package service;


import beans.Employee;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;

public class DriverTemporary {
	public static UserDAO uDao = new UserController();

	public static void main(String[] args) {
		Employee user = uDao.getUser(1);
		System.out.println(user);

	}

}
