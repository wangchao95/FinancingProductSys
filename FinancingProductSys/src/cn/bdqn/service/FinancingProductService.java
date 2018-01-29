package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.FinancingProduct;

/**
 * 产品服务类
 * @author Administrator
 *
 */
public interface FinancingProductService {
	/**
	 * 获得所有的产品
	 * @return
	 */
	List<FinancingProduct>getAllProduct();
	/**
	 * 获得某编号的产品
	 * @param id
	 * @param risk
	 * @return
	 */
	List<FinancingProduct>getProductByIdAndRisk(String id,int risk);
	/**
	 * 添加产品的方法
	 * @param finaProduct
	 * @return
	 */
	int addProduct(FinancingProduct finaProduct);
	
	int findAllproductById(String id);
}
