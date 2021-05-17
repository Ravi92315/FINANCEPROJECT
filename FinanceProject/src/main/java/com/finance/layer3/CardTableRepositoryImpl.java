package com.finance.layer3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;



/*
 * CardTable findCard(int cardNo);     //R - find/reading
	List<CardTable> findCard();  
 */
@Repository
public class CardTableRepositoryImpl implements CardTableRepository{
	
	@PersistenceContext
	 EntityManager entityManager;//auto injected by spring by reading 
										//persistance.xml file

	@Transactional
	public void addCard(CardTable caRef) {
		entityManager.persist(caRef);
		
	}

	@Transactional
	public CardTable findCard(int cardNo) {
		System.out.println("Order repo....NO scope of bussiness logic here...");
		return entityManager.find(CardTable.class,cardNo);
	
	}

	@Transactional
	public Set<CardTable> findAllCard() {
		// TODO Auto-generated method stub
		Set<CardTable> cardSet = new HashSet<>();
		TypedQuery<CardTable> query =
               entityManager.createNamedQuery("CardTable.findAll", CardTable.class);
                cardSet = (Set<CardTable>) query.getResultList();
       
       return cardSet;
	}

	@Transactional
	public void modifyCard(CardTable caRef) {
		entityManager.merge(caRef);
		
	}

	@Transactional
	public void removeCard(int cardNo) {
		// TODO Auto-generated method stub
		CardTable cardT = entityManager.find(CardTable.class,cardNo);
		entityManager.remove(cardT);
	}

	


}