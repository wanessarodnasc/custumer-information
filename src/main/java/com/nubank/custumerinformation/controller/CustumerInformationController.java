package com.nubank.custumerinformation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.custumerinformation.model.Custumer;
import com.nubank.custumerinformation.service.CustumerInformationService;

@RestController
public class CustumerInformationController {

	@Autowired
	private CustumerInformationService service;
	
	@GetMapping("custumer-information")
    public ResponseEntity<Custumer> authorizePayment(@Valid @RequestParam String cpf)  {
		Custumer custumer = service.getCustumerInformation(cpf);
    	return ResponseEntity.ok().body(custumer);
    }
	
}
