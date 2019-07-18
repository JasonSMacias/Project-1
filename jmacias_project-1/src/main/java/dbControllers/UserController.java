package dbControllers;

import java.util.List;

import beans.User;
import dataAccessObjects.UserDAO;

public class UserController implements UserDAO {

	@Override
	public void logIn(int usrId, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logOut(int usrId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User createUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
