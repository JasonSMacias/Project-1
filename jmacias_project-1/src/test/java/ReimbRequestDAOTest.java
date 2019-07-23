import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.junit.Test;

import beans.ReimbRequest;
import dataAccessObjects.ReimbRequestDAO;
import dbControllers.ReimbRequestController;

public class ReimbRequestDAOTest {
	@Test
	public void testRembReq() throws IOException {
		// testing addNewRequest and viewRequest
		LocalDate date = LocalDate.now( ZoneId.of( "America/New_York" ) );
		ReimbRequestDAO rDAO = new ReimbRequestController();
		ReimbRequest request = new ReimbRequest(22, 0.01, "Bit of string", date, "resolved");
		ReimbRequest returnedRequest = rDAO.addNewRequest(22, 0.01, "Bit of string");
		System.out.println("bean: " + request.getDescription() + " From db: " + returnedRequest.getDescription());
		assertEquals(request.getDescription(), returnedRequest.getDescription());
		ReimbRequest secondRequest = rDAO.viewRequest(returnedRequest.getId());
		assertEquals(secondRequest.getDescription(), returnedRequest.getDescription());
		
		List<ReimbRequest> reqList = rDAO.viewRequestsByEmployee(22);
		int arrSize = reqList.size();
		System.out.println("Array size: " + arrSize);
		for (ReimbRequest x : reqList) {
			System.out.println(x.getDescription());
		}
		assertEquals(reqList.get(0).getDescription(), request.getDescription());
		
		List<ReimbRequest> reqList2 = rDAO.viewRequestsByEmployee(22, "pending");
		int arrSize2 = reqList2.size();
		System.out.println("Array size: " + arrSize2);
		for (ReimbRequest x : reqList2) {
			System.out.println(x.getDescription());
		}
		assertEquals(reqList2.get(0).getDescription(), request.getDescription());
		
		List<ReimbRequest> reqList3 = rDAO.viewRequests();
		int arrSize3 = reqList3.size();
		System.out.println("Array size: " + arrSize3);
		boolean hasBitOfString = false;
		for (ReimbRequest x : reqList3) {
			System.out.println(x.getDescription());
			if (x.getDescription().equals("Bit of string")) {
				hasBitOfString = true;
			}
		}
		assertEquals(hasBitOfString, true);
		
		List<ReimbRequest> reqList4 = rDAO.viewRequests("pending");
		int arrSize4 = reqList4.size();
		System.out.println("Array size: " + arrSize4);
		boolean hasBitOfString2 = false;
		for (ReimbRequest x : reqList4) {
			System.out.println(x.getDescription());
			if (x.getDescription().equals("Bit of string")) {
				hasBitOfString2 = true;
			}
		}
		assertEquals(hasBitOfString2, true);
	}
}
