package com.VotreBanque.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.VotreBanque.spring.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    //HQL
	@Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
	public Page<Operation> listOperation(@Param("x")Long codeCpte, Pageable pageable);
}
