package com.te.assignmentmvc.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.assignmentmvc.base.dao.ProductDao;
import com.te.assignmentmvc.base.dto.ProductDetails;
import com.te.assignmentmvc.base.dto.ProductId;
import com.te.assignmentmvc.base.exception.ProductException;

@Service
public class ProductServiceImpli implements ProductService {
   @Autowired
	private ProductDao dao;
	@Override
	public ProductId authenticate(int id, String password) {
		if(id <= 0) {
			throw new ProductException("id should not be negative or 0 !!");
		}
		return dao.authenticate(id, password);
		
	}
	@Override
	public boolean addProduct(ProductDetails details) {	
			return dao.addProduct(details);
	}
	
	
	@Override
	public boolean deleteData(int id) {
		if(id<=0) {
			return false;
		}
		return dao.deleteData(id);
	}
	@Override
	public ProductDetails getDetails( int id) {
		
		if(id<=0) {
			return getDetails(id);
		}
		throw new ProductException("invalid id");
	}
	@Override
	public boolean update(ProductDetails details, int id) {
		
		return dao.update(details, id);
	}
	
	

}
