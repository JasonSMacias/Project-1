package dataAccessObjects;

import java.util.List;

import beans.Employee;

public interface UserDAO {
	public void logIn(int usrId, String password);
	public void logOut(int usrId);
	public Employee createUser(Employee newUser);
	public Employee getUser(int userId);
	public List<Employee> getUsers();
	public Employee updateUser(Employee updatedUser);
	public void removeUser(int userId);
}
