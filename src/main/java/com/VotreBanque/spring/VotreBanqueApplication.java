package com.VotreBanque.spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.VotreBanque.spring.dao.ClientRepository;
import com.VotreBanque.spring.dao.CompteRepository;
import com.VotreBanque.spring.dao.OperationRepository;
import com.VotreBanque.spring.entities.Client;
import com.VotreBanque.spring.entities.Compte;
import com.VotreBanque.spring.entities.CompteCourant;
import com.VotreBanque.spring.entities.CompteEpargne;
import com.VotreBanque.spring.entities.Retrait;
import com.VotreBanque.spring.entities.Versement;
import com.VotreBanque.spring.service.IBanqueService;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private IBanqueService banqueService;
	
	public static void main(String[] args) {
	  SpringApplication.run(VotreBanqueApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//		Client c1 = clientRepository.save(new Client("Hassan","hassan@gmail.com"));
//		Client c2 = clientRepository.save(new Client("Rachid","rachid@gmail.com"));
//
//		Compte cp1 = compteRepository.save(new CompteCourant((long) 1, new Date(), 9000, c1, 6000));
//		Compte cp2 = compteRepository.save(new CompteEpargne((long) 2, new Date(), 6.7, c2, 5.5));
//		
//		
//		operationRepository.save(new Versement(new Date(), 9000, cp1));
//		operationRepository.save(new Versement(new Date(), 800, cp1));
//		operationRepository.save(new Versement(new Date(), 2300, cp1));
//		operationRepository.save(new Retrait(new Date(), 9000, cp1));
//		
//		operationRepository.save(new Versement(new Date(), 9100, cp2));
//		operationRepository.save(new Versement(new Date(), 500, cp2));
//		operationRepository.save(new Versement(new Date(), 1300, cp2));
//		operationRepository.save(new Retrait(new Date(), 7000, cp2));
		
		//banqueService.verser((long) 1, 1111111);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
