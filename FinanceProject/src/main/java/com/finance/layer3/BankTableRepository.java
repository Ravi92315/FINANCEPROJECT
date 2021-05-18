package com.finance.layer3;


import java.util.Set;

import com.finance.layer2.BankTable;


public interface BankTableRepository {
	
	void addBankTable(BankTable bRef );   //C - add/create
	
	BankTable findBankTable(long accountNo);     //R - find/reading
	
	Set<BankTable> findAllBankTable();     //R - find all/reading all
	
	void modifyBankTable(BankTable bRef); //U - modify/update
	
	void removeBankTable(long accountNo); //D - remove/delete
}
