package com.finance.layer3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.BankTable;


@Repository
public class BankTableRepositoryImpl implements BankTableRepository {

	 @PersistenceContext
	 EntityManager entityManager;
	
	@Override
	@Transactional
	public void addBankTable(BankTable bRef ) {
		entityManager.persist(bRef);
	}

	@Transactional
	public BankTable findBankTable(long accountNo) {	
		return entityManager.find(BankTable.class, accountNo);
	}

	@Override
	@Transactional
	public Set<BankTable> findAllBankTable() {
		
		List<BankTable> list = new ArrayList<BankTable>();
		
		TypedQuery<BankTable> query = entityManager.createNamedQuery("BankTable.findAll", BankTable.class);
			  //RegistrationTableSet = (Set<RegistrationTable>) query.getResultList();
		list = query.getResultList();
		Set<BankTable> BankTableSet = new HashSet<BankTable>(list);
		return BankTableSet;
	}

	@Override
	@Transactional
	public void modifyBankTable(BankTable bRef) {
		entityManager.merge(bRef);
	}

	@Override
	@Transactional
	public void removeBankTable(long accountNo) {
		BankTable bnkTemp = entityManager.find(BankTable.class, accountNo);
		entityManager.remove(bnkTemp);
	}

}
