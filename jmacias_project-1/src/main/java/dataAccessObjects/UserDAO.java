package dataAccessObjects;

import java.util.List;

import beans.User;

public interface UserDAO {
	public void logIn(int usrId, String password);
	public void logOut(int usrId);
	public User createUser(User newUser);
	public User getUser(int userId);
	public List<User> getUsers();
	public User updateUser(User updatedUser);
}
