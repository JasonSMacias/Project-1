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
		User newUser = new Manager("pword", "What up?", "not much");
		User newUser2 = new Employee("password", "What is your middle name?", "Ignatius");
		User testUser = uDao.getUser(1);
		User testUser2 = uDao.getUser(2);
		assertEquals(newUser.getpWord(), testUser2.getpWord());
		assertEquals(newUser2.getpWord(), testUser.getpWord());
	}
}
