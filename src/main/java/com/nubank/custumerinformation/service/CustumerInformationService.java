package com.nubank.custumerinformation.service;

import com.nubank.custumerinformation.model.Custumer;

public interface CustumerInformationService {
	
	Custumer getCustumerInformation(String cpf);

	String updateCustumerCpfPayment(String cpf, boolean status);

}
