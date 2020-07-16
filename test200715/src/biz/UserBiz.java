package biz;

import entity.User;

public interface UserBiz {
	
	public User findUser(String userName);
	public void addUser(User user);
	
}