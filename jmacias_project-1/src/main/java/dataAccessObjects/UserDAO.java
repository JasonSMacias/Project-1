package dataAccessObjects;

import java.util.List;

import beans.Employee;

public interface UserDAO {
	public void logIn(int usrId, String password);
	public void logOut(int usrId);
	public Employee createUser(Employee newUser);
	public Employee getUser(int userId);
	public Employee getUserByName(String userName);
	public List<Employee> getUsers();
	public void updateUser(Employee updatedUser, String fieldChanged);
	public void removeUser(int userId);
}
