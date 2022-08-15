package com.portafolio.portafoliobackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.portafoliobackend.entity.Educacion;

@Repository
public interface IEducacion extends JpaRepository<Educacion, Integer> {
	
	public Optional<Educacion> findByNombreE(String nombreE);
	
	public boolean existsByNombreE(String nombreE);

}
