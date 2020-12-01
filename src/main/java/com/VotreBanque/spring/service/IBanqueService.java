package com.VotreBanque.spring.service;

import org.springframework.data.domain.Page;

import com.VotreBanque.spring.entities.Compte;
import com.VotreBanque.spring.entities.Operation;

public interface IBanqueService {
	
	public Compte consulterCompte(Long codeCpte);
	public void verser(Long codeCpte, double montant);
	public void retirer(Long codeCpte, double montant);
	public void virement(Long codeCpte1, Long codeCpte2, double montant);
    public Page<Operation> listOperations(Long codeCpte, int page, int size);
}
