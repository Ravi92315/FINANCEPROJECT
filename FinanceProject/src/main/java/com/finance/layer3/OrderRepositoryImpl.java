package com.finance.layer3;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.OrderTable;
import com.finance.layer2.TransactionTable;



@Repository
public class OrderRepositoryImpl implements OrderRepository {
	
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file

	@Transactional
	public void addOrder(OrderTable oRef) {
		entityManager.persist(oRef);
		
	}

	@Transactional
	public OrderTable findOrder(long ordno) {
		System.out.println("Order repo....NO scope of bussiness logic here...");
		return entityManager.find(OrderTable.class,ordno);
	
	}

	@Transactional
	public Set<OrderTable> findAllOrders() {
		// TODO Auto-generated method stub
		Set<OrderTable> orderSet = new HashSet<>();;
		TypedQuery<OrderTable> query =
                entityManager.createNamedQuery("OrderTable.findAll", OrderTable.class);
                 orderSet = (Set<OrderTable>) query.getResultList();
        
        return orderSet;
	}

	@Transactional
	public void modifyOrder(OrderTable oRef) {
		entityManager.merge(oRef);
		
	}

	@Transactional
	public void removeOrder(int ordno) {
		// TODO Auto-generated method stub
		OrderTable ordT = entityManager.find(OrderTable.class,ordno);
		entityManager.remove(ordT);
	}


}
