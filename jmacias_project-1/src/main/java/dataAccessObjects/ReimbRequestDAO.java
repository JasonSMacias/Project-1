package dataAccessObjects;

import java.util.List;

import beans.ReimbRequest;

public interface ReimbRequestDAO {
	// add new reimbursement request, return string confirmation
	public String addNewRequest(double value);
	public String addNewRequest(double value, String image);
	public List<ReimbRequest> viewRequest(int reqId);
	public List<ReimbRequest> viewRequestsByEmployee(int empId);
	public List<ReimbRequest> viewRequestsByEmployee(int empId, String status); // by status
	public List<ReimbRequest> viewRequests(); // all
	public List<ReimbRequest> viewRequests(String status); // all by status
	public ReimbRequest resolvePending(int reimbId);
	public String addImage(int reimbId, String imageInfo);
}
