package cn.bdqn.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.bdqn.dao.FinancingProductDao;
import cn.bdqn.dao.impl.FinancingProductDaoImpl;
import cn.bdqn.entity.FinancingProduct;
import cn.bdqn.service.FinancingProductService;
import cn.bdqn.util.DatabaseUtil;

public class FinancingProductServiceImpl implements FinancingProductService {

	@Override
	public List<FinancingProduct> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 查找产品的方法
	 */
	@Override
	public List<FinancingProduct> getProductByIdAndRisk(String id, int risk) {
		Connection conn=null;
		try {
			conn=DatabaseUtil.getConnection();
			FinancingProductDao financingProductDao=new FinancingProductDaoImpl(conn);
			 return financingProductDao.getProductByRiskAndId(risk, id);
		}finally {
			DatabaseUtil.closeAll(conn, null, null);
		}		
	}
	/**
	 * 添加产品的方法
	 */
	@Override
	public int addProduct(FinancingProduct finaProduct) {
		Connection conn=null;
		try {
			conn=DatabaseUtil.getConnection();
			FinancingProductDao financingProductDao=new FinancingProductDaoImpl(conn);
			 return financingProductDao.addProduct(finaProduct);
		}finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
	}
	/**
	 * 查找编号的产品
	 */
	@Override
	public int findAllproductById(String id) {
		Connection conn=null;
		try {
			conn=DatabaseUtil.getConnection();
			FinancingProductDao financingProductDao=new FinancingProductDaoImpl(conn);
			 return financingProductDao.getAllproductById(id);
		}finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
	}
}
