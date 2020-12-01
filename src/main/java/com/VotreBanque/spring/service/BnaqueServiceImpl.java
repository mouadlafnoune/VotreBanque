package com.VotreBanque.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.VotreBanque.spring.dao.CompteRepository;
import com.VotreBanque.spring.dao.OperationRepository;
import com.VotreBanque.spring.entities.Compte;
import com.VotreBanque.spring.entities.CompteCourant;
import com.VotreBanque.spring.entities.Operation;
import com.VotreBanque.spring.entities.Retrait;
import com.VotreBanque.spring.entities.Versement;

@Service
@Transactional
public class BnaqueServiceImpl implements IBanqueService {

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(Long codeCpte) {
		Compte cp = compteRepository.getOne(codeCpte);
		if(cp==null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(Long codeCpte, double montant) {

		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(Long codeCpte, double montant) {

		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse=0;
		if(cp instanceof CompteCourant)
			facilitesCaisse= ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("Solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
	}

	@Override
	public void virement(Long codeCpte1, Long codeCpte2, double montant) {
        retirer(codeCpte1, montant);
        verser(codeCpte2, montant);
        
	}

	@Override
	public Page<Operation> listOperations(Long codeCpte, int page, int size) {

		PageRequest pageable = PageRequest.of(page, size);
		return operationRepository.listOperation(codeCpte, pageable);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
