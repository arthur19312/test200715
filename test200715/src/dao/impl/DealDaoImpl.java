package dao.impl;

import dao.DealDao;
import dao.UserDao;
import entity.Deal;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DealDaoImpl extends BaseDao implements DealDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Deal findDeal(String dealId) {
		String sql = "select * from deal_table where deal_id = '"+dealId+"'";
		Deal deal = new Deal(); //�����û�����
		try {
			conn = this.getConn(); //������ݿ������
			pstmt = conn.prepareStatement(sql); //�õ�һ��statement����
			rs = pstmt.executeQuery(); //ִ��sql�õ������
			//��������е���Ϣȡ�����浽user��
			while(rs.next()){

				deal.setDealId(rs.getString("deal_id"));
				deal.setProductType(rs.getString("product_type"));
				deal.setBuyTimeYear(rs.getString("buy_time_year"));
				deal.setBuyTimeMonth(rs.getString("buy_time_month"));
				deal.setPrice(rs.getString("price"));
				deal.setNewLevel(rs.getString("new_level"));
				deal.setIntroduce(rs.getString("introduce"));
				deal.setContact(rs.getString("contact"));
				deal.setContactPhone(rs.getString("contact_phone"));
				deal.setUserName(rs.getString("user_name"));

				}
			}catch(Exception e){
				e.printStackTrace(); //�쳣����
				}finally{
					this.closeAll(conn, pstmt, rs);
					}
		return deal;
		}


	public ArrayList<Deal> getDeal() {
		String sql = "select * from deal_table";
		//�����û�����
		ArrayList<Deal> deals= new ArrayList<>();
		try {
			conn = this.getConn(); //������ݿ������
			pstmt = conn.prepareStatement(sql); //�õ�һ��statement����
			rs = pstmt.executeQuery(); //ִ��sql�õ������
			//��������е���Ϣȡ�����浽user��
			while(rs.next()){
				Deal deal = new Deal(rs.getString("deal_id"),
						rs.getString("product_type"),
						rs.getString("buy_time_year"),
						rs.getString("buy_time_month"),
						rs.getString("price"),
						rs.getString("new_level"),
						rs.getString("introduce"),
						rs.getString("contact"),
						rs.getString("contact_phone"),
						rs.getString("user_name"));

				System.out.println(deal.toString());
				deals.add(deal);
			}
		}catch(Exception e){
			e.printStackTrace(); //�쳣����
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return deals;
	}

	public void addDeal(Deal deal) {
        String sql = "insert into deal_table(deal_id,product_type,buy_time_year,buy_time_month,price,new_level," +
				"introduce,contact,contact_phone,user_name) values (?,?,?,?,?,?,?,?,?,?)";
        String[] parm = {deal.getDealId(),deal.getProductType(),deal.getBuyTimeYear()
				,deal.getBuyTimeMonth(),deal.getPrice(),deal.getNewLevel()
				,deal.getIntroduce(),deal.getContact(),deal.getContactPhone(),deal.getUserName()};
        this.executeSQL(sql,parm);
	}

}