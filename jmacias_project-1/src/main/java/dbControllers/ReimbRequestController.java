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
	public List<ReimbRequest> viewPending(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewResolved(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbRequest> viewAllPending() {
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
