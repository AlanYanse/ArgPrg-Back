package com.portafolio.portafoliobackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.portafoliobackend.entity.Experiencia;
import com.portafolio.portafoliobackend.repository.IExperiencia;

@Service
@Transactional
public class SExperiencia {

	@Autowired
	IExperiencia iExperiencia;

	public List<Experiencia> list() {

		return iExperiencia.findAll();
	}

	public Optional<Experiencia> getOne(int id) {

		return iExperiencia.findById(id);
	}

	public Optional<Experiencia> getByNombreE(String nombreE) {

		return iExperiencia.findByNombreE(nombreE);
	}

	public void save(Experiencia expe) {

		iExperiencia.save(expe);
	}

	public void delete(int id) {

		iExperiencia.deleteById(id);
	}

	public boolean existsById(int id) {

		return iExperiencia.existsById(id);
	}

	public boolean existsByNombreE(String nombreE) {

		return iExperiencia.existsByNombreE(nombreE);
	}

}
