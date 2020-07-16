package dao;

import entity.User;

public interface UserDao {
	
	public User findUser (String userName);
	
	public void addUser(User user);

}