package service;


import java.util.List;

import beans.ReimbRequest;
import dataAccessObjects.ReimbRequestDAO;
import dataAccessObjects.UserDAO;
import dbControllers.ReimbRequestController;
import dbControllers.UserController;

public class DriverTemporary {
	public static UserDAO uDao = new UserController();
	public static ReimbRequestDAO rDAO = new ReimbRequestController();

	public static void main(String[] args) {
		
		
		List<ReimbRequest> reqList = rDAO.viewRequests();
		int arrSize = reqList.size();
		System.out.println("Array size: " + arrSize);
		for (ReimbRequest x : reqList) {
			System.out.println(x.getDescription());
		}
		int tempId = reqList.get(0).getId();
		rDAO.resolvePending(tempId, reqList.get(0).getEmpId());
		ReimbRequest changed = rDAO.viewRequest(tempId);
		System.out.println("new status: " + changed.getStatus());

	}

}
