package com.VotreBanque.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VotreBanque.spring.entities.Compte;
import com.VotreBanque.spring.entities.Operation;
import com.VotreBanque.spring.service.IBanqueService;

@Controller
public class BanqueController{
	
	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	@RequestMapping("/consultercompte")
	public String consulter(Model model, Long codeCompte) {
		// pour la list operation
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp = banqueService.consulterCompte(codeCompte);
			// pour la list operation
			Page<Operation> pageOperations = banqueService.listOperations(codeCompte, 0, 4);
			model.addAttribute("listOperations", pageOperations.getContent());
			model.addAttribute("compte", cp);
		} catch (Exception e) {
            model.addAttribute("exception", e);
		}
		
		return "comptes";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
