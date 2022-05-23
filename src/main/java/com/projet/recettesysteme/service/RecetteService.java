package com.projet.recettesysteme.service;

import java.util.List;

import com.projet.recettesysteme.domain.Recette;
import com.projet.recettesysteme.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetteService {
	@Autowired
    RecetteRepository recetteRepository;

	public List<Recette> getAllRecettes() {
		return recetteRepository.findAll();
	}

	public void saveRecette(Recette recette) {
		this.recetteRepository.save(recette);
	}

	public Recette getRecetteById(Long id) {
		Recette recette = recetteRepository.getById(id);
		if (recette == null) {
			throw new RuntimeException("Cette recette existe-t-elle ?");
		}
		return recette;
	}

	public String deleteRecetteById(Long id) {
		Recette recette = recetteRepository.getById(id);
		if (recette == null) {
			throw new RuntimeException("Cette recette existe-t-elle ?");
		}
		recetteRepository.deleteById(id);
		return "Suppression : " + recette.getNameof() + " " + recette.getIngredients();
	}
}
