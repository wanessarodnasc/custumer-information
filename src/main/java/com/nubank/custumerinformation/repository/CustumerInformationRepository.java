package com.nubank.custumerinformation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubank.custumerinformation.model.Custumer;

@Repository
public interface CustumerInformationRepository extends JpaRepository<Custumer, Long>{

	Optional<Custumer> findByCpf(String cpf);

}
