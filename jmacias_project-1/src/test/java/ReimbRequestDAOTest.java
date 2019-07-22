import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

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
		ReimbRequest request = new ReimbRequest(22, 0.01, "Bit of string", date, "pending");
		ReimbRequest returnedRequest = rDAO.addNewRequest(22, 0.01, "Bit of string");
		System.out.println("bean: " + request.getDescription() + " From db: " + returnedRequest.getDescription());
		assertEquals(request.getDescription(), returnedRequest.getDescription());
		ReimbRequest secondRequest = rDAO.viewRequest(returnedRequest.getId());
		assertEquals(secondRequest.getDescription(), returnedRequest.getDescription());
	}
}
