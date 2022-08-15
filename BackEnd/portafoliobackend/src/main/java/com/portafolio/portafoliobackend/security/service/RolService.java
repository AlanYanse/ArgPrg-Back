package com.portafolio.portafoliobackend.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.portafoliobackend.security.entity.Rol;
import com.portafolio.portafoliobackend.security.enums.RolNombre;
import com.portafolio.portafoliobackend.security.repository.IRolRepository;

@Service
@Transactional
public class RolService {
	@Autowired
	IRolRepository irolRepository;

	public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
		return irolRepository.findByRolNombre(rolNombre);
	}

	public void save(Rol rol) {
		irolRepository.save(rol);
	}
}