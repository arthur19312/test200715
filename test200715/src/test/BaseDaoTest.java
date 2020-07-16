package test;

import java.sql.Connection;
import java.sql.SQLException;
import dao.impl.BaseDao;

public class BaseDaoTest {
	public static void main(String[] args){
		BaseDao baseDao = new BaseDao();
		Connection conn = null;
		try {
			conn = baseDao.getConn();
            System.out.println("数据库连接成功！");





			}catch(ClassNotFoundException e){
				e.printStackTrace();		
				}catch(SQLException e){
					e.printStackTrace();
					}finally{
						baseDao.closeAll(conn, null, null);	
						}
		}
	}