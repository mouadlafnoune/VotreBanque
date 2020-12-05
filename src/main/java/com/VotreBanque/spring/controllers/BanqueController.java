package com.VotreBanque.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String consulter(Model model, Long codeCompte, @RequestParam(name="page", defaultValue = "0")int page, @RequestParam(name="size", defaultValue = "5")int size) {
		// pour la list operation
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp = banqueService.consulterCompte(codeCompte);
			// pour la list operation
			Page<Operation> pageOperations = banqueService.listOperations(codeCompte, page, size);
			model.addAttribute("listOperations", pageOperations.getContent());
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("compte", cp);
		} catch (Exception e) {
            model.addAttribute("exception", e);
		}
		
		return "comptes";
	}
	
	@RequestMapping(value ="/saveOperation", method = RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation, Long codeCompte, double montant, Long codeCompte2) {
		
		try {
			if(typeOperation.equals("VERS")) {
				banqueService.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("RET")) {
				banqueService.retirer(codeCompte, montant);
			}
			if(typeOperation.equals("VIR")) {
				banqueService.virement(codeCompte, codeCompte2, montant);
			}
		} catch (Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consultercompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
		
		return "redirect:/consultercompte?codeCompte="+codeCompte;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
