package com.portafolio.portafoliobackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.portafoliobackend.entity.Proyecto;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
	
	public Optional<Proyecto> findByNombreProyecto(String nombreProyecto);
	public boolean existsByNombreProyecto(String nombreProyecto);

}
