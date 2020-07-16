package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.text.DateFormat;
import java.util.Date;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public User findUser(String userName) {
		String sql = "select * from user_table where user_name = '"+userName+"'";
		User user = new User(); //�����û�����
		try {
			conn = this.getConn(); //������ݿ������
			pstmt = conn.prepareStatement(sql); //�õ�һ��statement����
			rs = pstmt.executeQuery(); //ִ��sql�õ������
			//��������е���Ϣȡ�����浽user��
			while(rs.next()){
				user.setUserName(rs.getString("user_name"));
				user.setUserPsw(rs.getString("user_psw"));
				}
			}catch(Exception e){
				e.printStackTrace(); //�쳣����
				}finally{
					this.closeAll(conn, pstmt, rs);
					}
		return user;
		}

	public void addUser(User user) {
        String sql = "insert into user_table(user_name,user_psw) values (?,?)";
        String[] parm = {user.getUserName(),user.getUserPsw()};
        this.executeSQL(sql,parm);
	}

}