package web_study_11.dao;

import java.util.List;

import web_study_11.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll();
	
	int insertProduct(Product pdt);
	
	//int confirmId(String userId);
	
	//int userCheck(String userId, String pwd);
	
	int updateProduct(Product pdt);
	
	int deleteProduct(int code);
	
	Product selectProductByCode(int code);

	
	
	
	
}
