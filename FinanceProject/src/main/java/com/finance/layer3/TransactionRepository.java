package com.finance.layer3;

import java.util.Set;

import com.finance.layer2.TransactionTable;


public interface TransactionRepository {
	void addTransaction(TransactionTable tRef);   //C - add/create
	TransactionTable findTransaction(int transno);     //R - find/reading
	Set<TransactionTable> findAllTransactions();     //R - find all/reading all
	void modifyTransaction(TransactionTable tRef); //U - modify/update
	void removeTransaction(int transno); //D - remove/delete
}
