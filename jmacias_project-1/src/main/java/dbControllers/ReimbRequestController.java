package dbControllers;

import java.util.List;

import beans.ReimbRequest;
import dataAccessObjects.ReimbRequestDAO;

public class ReimbRequestController implements ReimbRequestDAO {

	@Override
	public String addNewRequest(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNewRequest(double value, String image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewRequest(int reqId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewRequestsByEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewRequestsByEmployee(int empId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewRequests(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbRequest resolvePending(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addImage(int reimbId, String imageInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
