package com.nubank.custumerinformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubank.custumerinformation.model.Custumer;

@Repository
public interface CustumerInformationRepository extends JpaRepository<Custumer, Long>{

	Custumer findByCpf(String cpf);

}
