//package com.finance;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import com.finance.layer2.ApprovalTable;
//import com.finance.layer2.RegistrationTable;
//import com.finance.layer3.ApprovalRepository;
//import com.finance.layer3.RegistrationTableRepository;
//
//@ContextConfiguration
//@SpringBootTest
//class ApprovalTest {
//	@Autowired
//	ApprovalRepository apvRepo;
//	@Autowired
//	RegistrationTableRepository regRepo;
//	
//	@Test
//	void addapprovaltest() {
//		RegistrationTable reg= new RegistrationTable();
//		reg=regRepo.findRegistrationTable(42);
//		ApprovalTable apr =new ApprovalTable();
//		apr.setApprovalStatus("YES");
//		apr.setCardFee(3000);
//		apr.setCardTable(null);
//		apr.set
//		apvRepo.addApproval(apr);
//	}
//
//}