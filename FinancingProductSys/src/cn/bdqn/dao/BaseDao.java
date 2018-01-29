package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.bdqn.util.DatabaseUtil;

/**
 * 公用类
 * @author Administrator
 *
 */
public class BaseDao {
	protected Connection conn=null;  
	protected PreparedStatement psm=null;
	
	public BaseDao(Connection conn) {
		this.conn=conn;
	}

	/**
	 * 增删改通用方法
	 * @param sql
	 * @param objects
	 * @return
	 */
	public int executeUpdate(String sql,Object...objects) {  
		int result=0;
		//conn=this.getConnection();  
		//PreparedStatement psm=null;   
		try {
			psm=conn.prepareStatement(sql);  
			for(int i=0;i<objects.length;i++) {  
				psm.setObject(i+1, objects[i]);   
			}
			result=psm.executeUpdate();   
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeAll(null, psm, null);
		}		
		return result;
	}
	
	/**
	 * 查询的通用方法
	 * @param sql
	 * @param objects
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object...objects) {
		//conn=getConnection();
		//PreparedStatement ps=null;  
		ResultSet rs=null; 	
		try {
			psm=conn.prepareStatement(sql);  
			for(int i=0;i<objects.length;i++) {
				psm.setObject(i+1, objects[i]);
			}
			rs=psm.executeQuery();  
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;   
	}
}
