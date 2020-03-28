package com.nubank.custumerinformation.service.imp;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.custumerinformation.enumeration.StatusEnum;
import com.nubank.custumerinformation.form.CustumerStatusForm;
import com.nubank.custumerinformation.model.Custumer;
import com.nubank.custumerinformation.repository.CustumerInformationRepository;
import com.nubank.custumerinformation.service.CustumerInformationService;

@Service
public class CustumerInformationServiceImp implements CustumerInformationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustumerInformationServiceImp.class);
	
	@Autowired
	private CustumerInformationRepository repository ;

	@Override
	public Custumer getCustumerInformation(String cpf) {
		LOGGER.info("Get custumer information by CPF.");
		Optional<Custumer> custumer = repository.findByCpf(cpf);
		if(custumer.isPresent()) {
			return custumer.get();
		}
		return null;
	}

	@Override
	public String updateCustumerCpfPayment(CustumerStatusForm custumerForm) {
		Boolean status = custumerForm.getStatus();
		LOGGER.info("Set cpf payment to " + custumerForm.getStatus());
		try {
			Optional<Custumer> custumer = repository.findByCpf(custumerForm.getCode());
			if(!custumer.isPresent()) {
				return "Custumer does not exist.";
			}
			custumer.get().setIsAvaliableToCpfPayment(status);
			repository.saveAndFlush(custumer.get());
			return returnMessage(status);
		} catch (Exception e) {
			return "Error to " + returnMessage(status);
		}
	}

	private String returnMessage(boolean status) {
		return status == true ? StatusEnum.ENABLED.getDescription() : StatusEnum.DISABLED.getDescription();
	}
}
