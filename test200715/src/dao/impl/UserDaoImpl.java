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
		User user = new User(); //声明用户对象
		try {
			conn = this.getConn(); //获得数据库的连接
			pstmt = conn.prepareStatement(sql); //得到一个statement对象
			rs = pstmt.executeQuery(); //执行sql得到结果集
			//将结果集中的信息取出保存到user中
			while(rs.next()){
				user.setUserName(rs.getString("user_name"));
				user.setUserPsw(rs.getString("user_psw"));
				}
			}catch(Exception e){
				e.printStackTrace(); //异常处理
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