package com.nubank.custumerinformation.service;

import com.nubank.custumerinformation.exception.BussinessException;
import com.nubank.custumerinformation.form.CustumerStatusForm;
import com.nubank.custumerinformation.model.Custumer;

public interface CustumerInformationService {
	
	Custumer getCustumerInformation(String cpf) throws BussinessException;

	String updateCustumerCpfPayment(CustumerStatusForm custumerStatusForm) throws BussinessException;

}
