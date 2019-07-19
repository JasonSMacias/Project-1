import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import beans.Employee;
import beans.Manager;
import beans.User;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;



public class UserControllerTest {
	@Test
	public void testGetUser() throws IOException {
		UserDAO uDao = new UserController();
		Employee newUser = new Employee("pword", "What up?", "not much", true);
		Employee newUser2 = new Employee("password", "What is your middle name?", "Ignatius", false);
		Employee testUser = uDao.getUser(1);
		Employee testUser2 = uDao.getUser(2);
		System.out.println("test user 2 security question: " + testUser2.getSecurityQ());
		assertEquals(newUser.getpWord(), testUser2.getpWord());
		assertEquals(newUser2.getpWord(), testUser.getpWord());
	}
}
