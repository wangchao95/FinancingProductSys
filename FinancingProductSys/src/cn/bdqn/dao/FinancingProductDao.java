package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.FinancingProduct;

public interface FinancingProductDao {
	/**
	 * 获得所有的产品
	 * @return
	 */
	List<FinancingProduct> getAllProduct();
	
	List<FinancingProduct>getProductByRiskAndId(int risk,String id);
	
	int addProduct(FinancingProduct finaProduct);
	
	int getAllproductById(String id);
}
