package com.finance.layer3;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.ProductTable;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	 EntityManager entityManager;
	
	@Transactional
	public void addProduct(ProductTable pRef) {
		entityManager.persist(pRef);
	}

	@Transactional
	public ProductTable findProduct(long productId) {
		System.out.println("Product Repositor......NO scope of bussiness logic here...");
		return entityManager.find(ProductTable.class,productId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ProductTable> findProduct() {
		     Set<ProductTable> ProductTableSet = new HashSet<>();      
             TypedQuery<ProductTable> query =
                entityManager.createNamedQuery("ProductTable.findAll", ProductTable.class);
                ProductTableSet = (Set<ProductTable>) query.getResultList();   
        return ProductTableSet;
	}

	@Transactional
	public void modifyProduct(ProductTable pRef) {
		entityManager.merge(pRef);

	}

	@Transactional
	public void removeProduct(long productId) {
		ProductTable pTemp = entityManager.find(ProductTable.class,productId);
		entityManager.remove(pTemp);
	}

	@Override
	public ProductTable findProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

}
