package com.nubank.custumerinformation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "custumer")
public class Custumer implements Serializable {
	
	private static final long serialVersionUID = -8183945029317727347L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "complete_name", nullable = false)
	private String completeName;
	
	@Column(name = "card_number", nullable = false)
	private String cardNumber;
	
	@Column(name = "expired_date", nullable = false)
	private String expiredDate;
	
	@Column(name = "code", nullable = false)
	private String code; 
	
	@Column(name = "is_avaliable_cpf_payment", nullable = false)
	private Boolean isAvaliableToCpfPayment;

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsAvaliableToCpfPayment() {
		return isAvaliableToCpfPayment;
	}

	public void setIsAvaliableToCpfPayment(Boolean isAvaliableToCpfPayment) {
		this.isAvaliableToCpfPayment = isAvaliableToCpfPayment;
	}
}
