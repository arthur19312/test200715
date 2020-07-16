package biz.impl;

import biz.UserBiz;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

public class UserBizImpl implements UserBiz{
	
	private UserDao userDao = new UserDaoImpl();

	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public User findUser(String userName) {
		return userDao.findUser(userName);
	}

	
}