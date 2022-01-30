package com.te.assignmentmvc.base.dao;

import com.te.assignmentmvc.base.dto.ProductDetails;
import com.te.assignmentmvc.base.dto.ProductId;

public interface ProductDao {
	
	public ProductId authenticate(int id,String password); 
	
	public  boolean addProduct(ProductDetails details); 
	
	public boolean deleteData(int id);
	
	public ProductDetails  getDetails(int id) ;
		
	public boolean update(ProductDetails details,int id);

}
