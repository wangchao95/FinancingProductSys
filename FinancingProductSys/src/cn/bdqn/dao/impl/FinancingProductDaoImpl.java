package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.FinancingProductDao;
import cn.bdqn.entity.FinancingProduct;

public class FinancingProductDaoImpl extends BaseDao implements FinancingProductDao {

	public FinancingProductDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FinancingProduct> getAllProduct() {
		
		return null;
	}
	/**
	 * 鏌ヨ浜у搧鐨勬柟娉�
	 */
	@Override
	public List<FinancingProduct> getProductByRiskAndId(int risk, String id) {
		String sql="SELECT * FROM `financingproduct` where 1=1";
		List<Object> obs=new ArrayList<Object>();   //瀛樻斁鍙�
		List<FinancingProduct> productList=new ArrayList<FinancingProduct>();
		if(id!=null&&id!="") {
			sql+=" and `id` LIKE ?";
			obs.add("%"+id+"%");
		}
		if(risk!=0) {		
			sql+=" and `risk`= ?";
			obs.add(risk);
		}
		sql+=" order by saleStarting desc";	
		ResultSet rs=executeQuery(sql, obs.toArray());
		//濡傛灉瀛樺湪涓嬩竴琛�
		try {
			while(rs.next()) {  
				//鑾峰彇
				FinancingProduct product=new FinancingProduct();
				product.setId(rs.getString("id"));
				product.setRisk(rs.getInt("risk"));
				product.setIncome(rs.getString("income"));			
				product.setSaleStarting(rs.getDate("saleStarting"));
				product.setSaleEnd(rs.getDate("saleEnd"));
				product.setEnd(rs.getDate("end"));
				
				productList.add(product);  //娣诲姞鍒扮粨鍚堜腑鍘�
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	/**
	 * 娣诲姞浜у搧
	 */
	@Override
	public int addProduct(FinancingProduct finaProduct) {		
			String sql="insert into financingproduct(`id`,`risk`,`income`,`saleStarting`,`saleEnd`,`end`) values(?,?,?,?,?,?)";
			return executeUpdate(sql, finaProduct.getId(),finaProduct.getRisk(),finaProduct.getIncome(),finaProduct.getSaleStarting(),finaProduct.getSaleEnd(),finaProduct.getEnd());		
			
	}
	/**
	 * 鏌ユ壘id鐨勪骇鍝佺殑涓暟
	 */
	@Override
	public int getAllproductById(String id) {
		String sql="SELECT COUNT(1) FROM `financingproduct where id=?";
		ResultSet rs=executeQuery(sql,id);
		int result=0;
		try {
			while(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
