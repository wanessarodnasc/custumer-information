package com.nubank.custumerinformation.service.imp;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.custumerinformation.enumeration.StatusEnum;
import com.nubank.custumerinformation.exception.BussinessException;
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
	public Custumer getCustumerInformation(String cpf) throws BussinessException {
		LOGGER.info("Get custumer information by CPF.");
		return getCustumer(cpf);
	}

	@Override
	public String updateCustumerCpfPayment(CustumerStatusForm custumerForm) {
		Boolean status = custumerForm.getStatus();
		LOGGER.info("Set cpf payment to " + custumerForm.getStatus());
		try {
			Custumer custumer = getCustumer(custumerForm.getCode());
			custumer.setIsAvaliableToCpfPayment(status);
			repository.save(custumer);
			return returnMessage(status);
		} catch (Exception e) {
			return "Error to " + returnMessage(status);
		}
	}

	private Custumer getCustumer(String cpf) throws BussinessException {
		Optional<Custumer> custumer = repository.findByCpf(cpf);
		if(!custumer.isPresent()) {
			throw new BussinessException(StatusEnum.DOES_NOT_EXIST.getDescription());
		}
		return custumer.get();
	}

	private String returnMessage(boolean status) {
		return status == true ? StatusEnum.ENABLED.getDescription() : StatusEnum.DISABLED.getDescription();
	}
}
