package com.portafolio.portafoliobackend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.portafoliobackend.dto.DtoExperiencia;
import com.portafolio.portafoliobackend.dto.DtoSkill;
import com.portafolio.portafoliobackend.entity.Experiencia;
import com.portafolio.portafoliobackend.entity.Skill;
import com.portafolio.portafoliobackend.security.controller.Mensaje;
import com.portafolio.portafoliobackend.service.SSKill;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill {

	@Autowired
	SSKill sSkill;

	@GetMapping("/lista")
	public ResponseEntity<List<Experiencia>> list() {

		List<Skill> list = sSkill.list();

		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Skill> getById(@PathVariable("id") int id) {

		if (!sSkill.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}

		Skill skill = sSkill.getOne(id).get();
		return new ResponseEntity(skill, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		if (!sSkill.existsById(id)) {

			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		
		sSkill.delete(id);
		return new ResponseEntity(new Mensaje("Elemento Eliminado"), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody DtoSkill dtoSkill) {

		if (StringUtils.isBlank(dtoSkill.getNombreSkill())) {

			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}

		if (sSkill.existsByNombreSkill(dtoSkill.getNombreSkill())) {

			return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
		}

		Skill skill = new Skill(dtoSkill.getNombreSkill(), dtoSkill.getDescripcionSkill(), dtoSkill.getImg(),  dtoSkill.getPercent());
		sSkill.save(skill);

		return new ResponseEntity(new Mensaje("Nueva habilidad ha sido salvada"), HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill) {

		// Validación existencia del id

		if (!sSkill.existsById(id)) {

			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		}

		// Compara nombre de experiencias

		if (sSkill.existsByNombreSkill(dtoSkill.getNombreSkill())
				&& sSkill.getByNombreSkill(dtoSkill.getNombreSkill()).get().getId() != id) {

			return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);

		}

		// No puede estar vacío

		if (StringUtils.isBlank(dtoSkill.getNombreSkill())) {

			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		
		// Llegó hasta acá

		Skill skill = sSkill.getOne(id).get();
		skill.setNombreSkill(dtoSkill.getNombreSkill());
		skill.setDescripcionSkill(dtoSkill.getDescripcionSkill());
		skill.setImg(dtoSkill.getImg());
		skill.setPercent(dtoSkill.getPercent());

		sSkill.save(skill);
		return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);

	}

}
