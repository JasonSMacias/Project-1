package service;

import beans.User;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;

public class DriverTemporary {
	public static UserDAO uDao = new UserController();

	public static void main(String[] args) {
		User user1 = uDao.getUser(1);
		System.out.println(user1.getId());

	}

}
