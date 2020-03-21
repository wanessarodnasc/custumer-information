package com.nubank.custumerinformation.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.custumerinformation.model.Custumer;
import com.nubank.custumerinformation.repository.CustumerInformationRepository;
import com.nubank.custumerinformation.service.CustumerInformationService;

@Service
public class CustumerInformationServiceImp implements CustumerInformationService {
	
	@Autowired
	private CustumerInformationRepository repository ;

	@Override
	public Custumer getCustumerInformation(String cpf) {
		return repository.findByCpf(cpf);
	}
}
