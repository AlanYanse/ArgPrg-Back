package com.portafolio.portafoliobackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.portafoliobackend.entity.Experiencia;

@Repository
public interface IExperiencia extends JpaRepository<Experiencia, Integer> {
	
	public Optional<Experiencia> findByNombreE(String nombreE);
	
	public boolean existsByNombreE(String nombreE);
	
	

}
