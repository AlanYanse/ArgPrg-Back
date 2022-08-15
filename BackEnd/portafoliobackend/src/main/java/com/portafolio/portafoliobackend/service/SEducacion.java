package com.portafolio.portafoliobackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.portafoliobackend.entity.Educacion;
import com.portafolio.portafoliobackend.repository.IEducacion;

@Service
@Transactional
public class SEducacion {
	
	@Autowired
	IEducacion iEducacion;
	
	public List<Educacion> list(){
		return iEducacion.findAll();
	}
	
	public Optional<Educacion> getOne(int id){
		return iEducacion.findById(id);
	}
	
	public Optional<Educacion> getByNombreE(String nombreE){
		return iEducacion.findByNombreE(nombreE);
	}
	
	public void save(Educacion educacion) {
		iEducacion.save(educacion);
	}
	
	public void delete(int id) {
		iEducacion.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return iEducacion.existsById(id);
	}
	
	public boolean existsByNombreE(String nombreE) {
		return iEducacion.existsByNombreE(nombreE);
	}

}
