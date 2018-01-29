package cn.bdqn.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DatabaseUtil {
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection() {		
	 Connection conn=null;   
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/product");
			conn=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 * @param ste
	 * @param re
	 */
	public static void closeAll(Connection conn,Statement ste,ResultSet re) {
		try {
			//关闭res对象
			if(re!=null&&!re.isClosed()) {
				re.close();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		try {
			//判断，关闭对象
			if(ste!=null&&!ste.isClosed()) {
				ste.close();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}

		try {
			
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
}
