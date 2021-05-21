package com.example.demo;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.finance.layer2.*;
import com.finance.layer3.*;
@SpringBootTest
class FinanceProjectApplicationTests {
		@Autowired
		RegistrationTableRepository regRepo;
		@Test
		void contextLoads() {
			System.out.println("hiii");
			System.out.println(regRepo.findRegistrationTable(963258).getName());		
	}
}
