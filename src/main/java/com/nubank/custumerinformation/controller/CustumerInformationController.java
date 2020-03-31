package com.nubank.custumerinformation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.custumerinformation.exception.BussinessException;
import com.nubank.custumerinformation.form.CustumerStatusForm;
import com.nubank.custumerinformation.model.Custumer;
import com.nubank.custumerinformation.service.CustumerInformationService;

@RestController
public class CustumerInformationController {

	@Autowired
	private CustumerInformationService service;
	
	@GetMapping("search-custumer")
    public ResponseEntity<Custumer> searchCustumer(@Valid @RequestParam String cpf) throws BussinessException  {
		Custumer custumer = service.getCustumerInformation(cpf);
    	return ResponseEntity.ok().body(custumer);
    }
	
	@PutMapping("update-custumer-information")
    public ResponseEntity<String> updateCustumerCpfPayment(@Valid @RequestBody CustumerStatusForm custumerForm) throws BussinessException  {
		String custumer = service.updateCustumerCpfPayment(custumerForm);
    	return ResponseEntity.ok().body(custumer);
    }
}
