package biz;

import entity.Deal;

import java.util.ArrayList;

public interface DealBiz {
	
	public Deal findDeal(String dealId);
    public ArrayList<Deal> getDeal();
	public void addDeal(Deal deal);
	
}