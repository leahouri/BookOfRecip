package com.projet.recettesysteme.controller;

import com.projet.recettesysteme.domain.Recette;
import com.projet.recettesysteme.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecetteController {

	@Autowired
    RecetteService recetteService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listRecettes", recetteService.getAllRecettes());
		return "index";
	}
	@GetMapping("/nouveau")
	public String showNewRecetteForm(Model model) {
		Recette recette = new Recette();
		model.addAttribute("recette", recette);
		return "new_recette";
	}

	@PostMapping("/enregistre")
	public String saveRecette(@ModelAttribute("recette") Recette recette) {
		recetteService.saveRecette(recette);
		return "redirect:/";
	}


	@GetMapping("/modification/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model) {
		Recette recette = recetteService.getRecetteById(id);
		model.addAttribute("recette", recette);
		return "update_recette";
	}

	@GetMapping("/suppression/{id}")
	public String deleteRecetteById(@PathVariable Long id, Model model) {
		recetteService.deleteRecetteById(id);
		return "redirect:/";
	}
}
