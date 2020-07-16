package biz.impl;

import biz.DealBiz;
import biz.UserBiz;
import dao.DealDao;
import dao.UserDao;
import dao.impl.DealDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Deal;
import entity.User;

import java.util.ArrayList;

public class DealBizImpl implements DealBiz {
	
	private DealDao dealDao = new DealDaoImpl();

	public Deal findDeal(String dealId) {
		return dealDao.findDeal(dealId);
	}
	
	public ArrayList<Deal> getDeal() {
		return dealDao.getDeal();
	}

	public void addDeal(Deal deal) {
		dealDao.addDeal(deal);
	}


	
}