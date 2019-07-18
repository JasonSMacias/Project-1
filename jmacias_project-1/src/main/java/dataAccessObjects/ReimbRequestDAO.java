package dataAccessObjects;

import java.util.List;

import beans.ReimbRequest;

public interface ReimbRequestDAO {
	// add new reimbursement request, return string confirmation
	public String addNewRequest(double value);
	public String addNewRequest(double value, String image);
	public List<ReimbRequest> viewPending(int empId);
	public List<ReimbRequest> viewResolved(int empId);
	public List<ReimbRequest> viewAllPending();
	public ReimbRequest resolvePending(int reimbId);
	public String addImage(int reimbId, String imageInfo);
}
