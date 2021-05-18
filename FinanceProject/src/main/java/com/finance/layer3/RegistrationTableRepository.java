package com.finance.layer3;


import java.util.Set;

import com.finance.layer2.RegistrationTable;


public interface RegistrationTableRepository {
	
	void addRegistrationTable(RegistrationTable rRef );   //C - add/create
	
	RegistrationTable findRegistrationTable(long adharCard);     //R - find/reading
	
	Set<RegistrationTable> findAllRegistrationTable();     //R - find all/reading all
	
	void modifyRegistrationTable(RegistrationTable dRef); //U - modify/update
	
	void removeRegistrationTable(long adharCard); //D - remove/delete
}
