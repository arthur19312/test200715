package dao.impl;

import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {
	
	public final static String driver = "com.mysql.jdbc.Driver";
	public final static String url = "jdbc:mysql://localhost:3306/1173710212?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public final static String dbName = "root";
	public final static String dbPass = "123456";
	
	public Connection getConn() throws ClassNotFoundException,SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,dbName,dbPass);
		return conn;
		}
	
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs != null){
			try{
				rs.close();
				}catch(SQLException e){
					e.printStackTrace();
					}		
			}
		if(pstmt != null){
			try{
				pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
					}			
			}
		if(conn != null){
			try{
				conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					}	
			}
		}
	
	public int executeSQL(String preparedSql,String[] param){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement(preparedSql);
			if(param != null){
				for(int i = 0;i < param.length;i++){
					pstmt.setString(i+1, param[i]);				
					}
				}
			num = pstmt.executeUpdate();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
					}finally{
						closeAll(conn,pstmt,null);
						}
		return num;
	}	
}