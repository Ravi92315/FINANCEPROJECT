package com.finance.layer3;


import java.util.Set;

import org.springframework.stereotype.Repository;

import com.finance.layer2.RegistrationTable;

@Repository
public interface RegistrationTableRepository {
	
	void addRegistrationTable(RegistrationTable rRef );   //C - add/create
	
	RegistrationTable findRegistrationTable(long regId);     //R - find/reading
	
	Set<RegistrationTable> findAllRegistrationTable();     //R - find all/reading all
	
	void modifyRegistrationTable(RegistrationTable dRef); //U - modify/update
	
	void removeRegistrationTable(long regId); //D - remove/delete
}