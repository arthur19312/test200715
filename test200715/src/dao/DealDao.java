package dao;

import entity.Deal;
import entity.User;

import java.util.ArrayList;

public interface DealDao {

	public Deal findDeal(String dealId);

	public ArrayList<Deal> getDeal();
	
	public void addDeal(Deal deal);

}