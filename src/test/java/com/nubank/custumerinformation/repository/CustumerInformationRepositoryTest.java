package com.nubank.custumerinformation.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nubank.custumerinformation.model.Custumer;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class CustumerInformationRepositoryTest {
	
	@Autowired
	private CustumerInformationRepository repository;

	@Test
	public void saveUser() throws Exception {
		Custumer custumerInformation = repository.save(new Custumer());
		assertNotNull(custumerInformation.getId());
	}
	
	@Test
	public void findByCpf() throws Exception {
		assertNotNull(repository.findByCpf("35177355221"));
	}
}
