package com.nubank.custumerinformation.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubank.custumerinformation.model.Custumer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustumerInformationServiceTest {
	
	@Autowired
	private CustumerInformationService service;
	
	@Test
	public void getCustumerInformation() {
		Custumer custumer = service.getCustumerInformation("35177355221");
		assertNotNull(custumer);
	}
	
	@Test
	public void updateCustumerCpfPayment() {
		Custumer custumer = service.getCustumerInformation("35177355221");
		if(custumer.getIsAvaliableToCpfPayment() == true) {
			service.updateCustumerCpfPayment("35177355221", false);
			Custumer custumerTrue = service.getCustumerInformation("35177355221");
			assertEquals(custumerTrue.getIsAvaliableToCpfPayment(), false);
		}
		if(custumer.getIsAvaliableToCpfPayment() == false) {
			service.updateCustumerCpfPayment("35177355221", true);
			Custumer custumerTrue = service.getCustumerInformation("35177355221");
			assertEquals(custumerTrue.getIsAvaliableToCpfPayment(), true);
		}
	}
}