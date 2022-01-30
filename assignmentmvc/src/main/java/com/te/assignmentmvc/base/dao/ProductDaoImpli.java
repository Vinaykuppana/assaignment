package com.te.assignmentmvc.base.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.assignmentmvc.base.dto.ProductDetails;
import com.te.assignmentmvc.base.dto.ProductId;
import com.te.assignmentmvc.base.exception.ProductException;

@Repository
public class ProductDaoImpli implements ProductDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductId authenticate(int id, String password) {
		EntityManager manager = factory.createEntityManager();
		ProductId productId = manager.find(ProductId.class, id);
		if (productId != null) {
			if (productId.getPassword().equals(password)) {
				return productId;
			} else {
				throw new ProductException("invalid password please enter the right password");
			}
		}

		throw new ProductException("invalid user id");
	}

	@Override
	public boolean addProduct(ProductDetails details) {
		boolean addProduct = false;
		EntityTransaction transaction = null;

		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(details);
			addProduct = true;
			transaction.commit();			
		} catch (Exception e) {
			if (details != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return addProduct;
	}

	@Override
	public boolean deleteData(int id) {
		boolean isDeleted = false;
		EntityTransaction transaction = null;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			ProductDetails details =manager.find(ProductDetails.class, id);
			transaction.begin();
			manager.persist(details);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public ProductDetails getDetails(int id) {
		EntityManager manager = factory.createEntityManager();
		ProductDetails details2=manager.find(ProductDetails.class, id);		
		if(details2 != null) {
			return details2;
		}
		 throw new ProductException("details not found for id"+id);
	}

	@Override
	public boolean update(ProductDetails details, int id) {
		boolean isUpdate = false;
		EntityTransaction transaction = null;
		try {
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			ProductDetails  details2=manager.find(ProductDetails.class, id);
			details2.setName(details.getName());
			details2.setCompany(details.getCompany());
			 
			transaction.begin();
			manager.persist(details2);
			transaction.commit();
			isUpdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isUpdate;
	}

}
