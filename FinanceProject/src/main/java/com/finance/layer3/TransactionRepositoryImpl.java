package com.finance.layer3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.TransactionTable;

public class TransactionRepositoryImpl implements TransactionRepository  {
	
	@PersistenceContext
	 EntityManager entityManager;
	
	@Transactional
	public void addTransaction(TransactionTable tRef) {
		entityManager.persist(tRef);
	}

	@Transactional
	public TransactionTable findTransaction(int transno) {
		System.out.println("Department repo....NO scope of bussiness logic here...");
		return entityManager.find(TransactionTable.class,transno);
	}

	@Transactional
	public Set<TransactionTable> findAllTransactions() {
		// TODO Auto-generated method stub
		Set<TransactionTable> transactionSet = new HashSet<>();
        
        TypedQuery<TransactionTable> query =
                entityManager.createNamedQuery("TransactionTable.findAll", TransactionTable.class);
                 transactionSet = (Set<TransactionTable>) query.getResultList();
        
        return transactionSet;
	
	}

	@Transactional
	public void modifyTransaction(TransactionTable tRef) {
		entityManager.merge(tRef);
		
	}

	@Transactional
	public void removeTransaction(int transno) {
		TransactionTable transT = entityManager.find(TransactionTable.class,transno);
		entityManager.remove(transT);
		
	}

}
