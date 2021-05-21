package com.finance.layer3;


import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.CardTable;
@Repository
public interface CardTableRepository {
	void addCard(CardTable cRef);   //C - add/create
	CardTable findCard(int cardNo);     //R - find/reading
	Set<CardTable> findAllCard();     //R - find all/reading all
	void modifyCard(CardTable cRef); //U - modify/update
	void removeCard(int cardNo); //D - remove/delete
}
