import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import beans.Employee;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;



public class UserControllerTest {
	@Test
	public void testGetUser() throws IOException {
		// testing createUser, getUser, updateUser and uses removeUser to clean up
		UserDAO uDao = new UserController();
		Employee newUser = new Employee("Victor", "ppppb", "qqqqb", "aaaabb", true);
		Employee newUser2 = new Employee("Victoria", "pab", "qab", "abb", false);
		Employee createdUser = uDao.createUser(newUser);
		Employee createdUser2 = uDao.createUser(newUser2);
		Employee testUser = uDao.getUser(createdUser.getId());
		Employee testUser2 = uDao.getUser(createdUser2.getId());
		System.out.println("new user " + newUser.getSecurityQ());
		System.out.println("created user " + createdUser.getSecurityQ());
		System.out.println("test user " + testUser.getSecurityQ());
		assertEquals(newUser.getpWord(), createdUser.getpWord());
		assertEquals(newUser.getpWord(), testUser.getpWord());
		assertEquals(newUser2.getpWord(), createdUser2.getpWord());
		assertEquals(newUser2.getpWord(), testUser2.getpWord());
		createdUser.setName("Berthold");
		createdUser2.setSecurityQ("Where am I?");
		uDao.updateUser(createdUser, "name");
		uDao.updateUser(createdUser2, "securityQ");
		Employee lastTest = uDao.getUser(createdUser.getId());
		Employee lastTest2 = uDao.getUser(createdUser2.getId());
		assertEquals(lastTest.getName(), "Berthold");
		assertEquals(lastTest2.getSecurityQ(), "Where am I?");
		uDao.removeUser(createdUser.getId());
		uDao.removeUser(createdUser2.getId());
	}
	
	
}
