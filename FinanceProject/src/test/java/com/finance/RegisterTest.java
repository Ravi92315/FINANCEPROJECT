package com.finance;

import java.time.LocalDate;
import java.util.Date;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.finance.layer2.ApprovalTable;
import com.finance.layer2.CardTable;
import com.finance.layer2.OrderTable;
import com.finance.layer2.ProductTable;
import com.finance.layer2.RegistrationTable;
import com.finance.layer3.ApprovalRepository;
//import com.finance.layer3.CardRepository;
import com.finance.layer3.OrderRepository;
import com.finance.layer3.RegistrationTableRepository;


@ContextConfiguration
@SpringBootTest
class RegistertTests {
	
	@Autowired
	RegistrationTableRepository regRepo;
	

	
	CardTable crd=null;
	
	
	@Test
	void RegisterFindtest() {
		System.out.println("-----------------------------------");
		RegistrationTable reg = regRepo.findRegistrationTable(2);
		System.out.println(reg.getRegId());
		System.out.println(reg.getName());
		System.out.println(reg.getPhoneNo());
		System.out.println(reg.getEmailId());
		System.out.println(reg.getUsername());
		System.out.println(reg.getPassword());
		System.out.println(reg.getAddress());
		System.out.println(reg.getCardType());
		System.out.println(reg.getRegistrationDate());
		System.out.println(reg.getDob());
		System.out.println(reg.getAdharCard());
		System.out.println("-----------------------------------");
	}
	@Test
	void RegisterFindAllTest()
	{
		
		
		Set<RegistrationTable> regSet = regRepo.findAllRegistrationTable();
		for (RegistrationTable r: regSet) {
			System.out.println("-----------------------------------");
			System.out.println(r.getRegId());
			System.out.println(r.getName());
			System.out.println(r.getPhoneNo());
			System.out.println(r.getEmailId());
			System.out.println(r.getUsername());
			System.out.println(r.getPassword());
			System.out.println(r.getAddress());
			System.out.println(r.getCardType());
			System.out.println(r.getRegistrationDate());
			System.out.println(r.getDob());
			System.out.println(r.getAdharCard());
			System.out.println("-----------------------------------");
	}
	
	}
	@Test
	void AddRegistertest() {
		System.out.println("-----------------------------------------");
		RegistrationTable reg = new RegistrationTable(); 
		//reg.setRegId(4);
		reg.setName("DHONI");
		reg.setPhoneNo(9874561);
		reg.setEmailId("D@sir");
		reg.setUsername("Dhoni");
		reg.setPassword("BATSMAN");
		reg.setAddress("CHENAI");
		reg.setCardType("Gold");
		reg.setRegistrationDate(LocalDate.of(1986,7,8));
		reg.setDob(LocalDate.of(1991,10,20));
		reg.setAdharCard(77777);
		regRepo.addRegistrationTable(reg);
		System.out.println("----------------------------------------------");
	}
	
	@Test
	void Deletetest() {
		System.out.println("-----------------------------------");
		regRepo.removeRegistrationTable(41);
		System.out.println("************************************");
	}
	
	@Test
	void Modifytest() {
		System.out.println("-----------------------------------");
		RegistrationTable reg = regRepo.findRegistrationTable(42);
		reg.setAddress("MUMBAI");
	    reg.setName("VISHALSIR");
	    regRepo.modifyRegistrationTable(reg);
	    System.out.println("/////////////////////////////////////");
	}
	
}
