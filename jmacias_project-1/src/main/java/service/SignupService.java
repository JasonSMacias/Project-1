package service;

import dataAccessObjects.ReimbRequestDAO;
import dataAccessObjects.UserDAO;
import dbControllers.ReimbRequestController;
import dbControllers.UserController;

public class SignupService {
	private static UserDAO uDao = new UserController();
	private static ReimbRequestDAO rDAO = new ReimbRequestController();
}
