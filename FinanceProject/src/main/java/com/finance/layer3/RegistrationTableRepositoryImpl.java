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

import com.finance.layer2.RegistrationTable;

@Repository
public class RegistrationTableRepositoryImpl implements RegistrationTableRepository {

	 @PersistenceContext
	 EntityManager entityManager;
	
	@Override
	@Transactional
	public void addRegistrationTable(RegistrationTable rRef) {
		entityManager.persist(rRef);
	}

	@Transactional
	public RegistrationTable findRegistrationTable(long adharCard) {	
		return entityManager.find(RegistrationTable.class, adharCard);
	}

	@Override
	@Transactional
	public Set<RegistrationTable> findAllRegistrationTable() {
		
		List<RegistrationTable> list = new ArrayList<RegistrationTable>();
		
		TypedQuery<RegistrationTable> query = entityManager.createNamedQuery("RegistrationTable.findAll", RegistrationTable.class);
			  //RegistrationTableSet = (Set<RegistrationTable>) query.getResultList();
		list = query.getResultList();
		Set<RegistrationTable> RegistrationTableSet = new HashSet<RegistrationTable>(list);
		return RegistrationTableSet;
	}

	@Override
	@Transactional
	public void modifyRegistrationTable(RegistrationTable rRef) {
		entityManager.merge(rRef);
	}

	@Override
	@Transactional
	public void removeRegistrationTable(long adharCard) {
		RegistrationTable regTemp = entityManager.find(RegistrationTable.class, adharCard);
		entityManager.remove(regTemp);
	}

}
