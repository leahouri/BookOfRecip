package com.projet.recettesysteme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.recettesysteme.domain.Recette;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
