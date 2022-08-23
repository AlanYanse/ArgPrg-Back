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


import com.portafolio.portafoliobackend.dto.DtoProyecto;
import com.portafolio.portafoliobackend.entity.Proyecto;
import com.portafolio.portafoliobackend.security.controller.Mensaje;
import com.portafolio.portafoliobackend.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
	
	@Autowired
	ProyectoService proyectoService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<Proyecto>> list() {

		List<Proyecto> list = proyectoService.list();

		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {

		if (!proyectoService.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}

		Proyecto proyecto = proyectoService.getOne(id).get();
		return new ResponseEntity(proyecto, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		if (!proyectoService.existsById(id)) {

			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		
		proyectoService.delete(id);
		return new ResponseEntity(new Mensaje("Elemento Eliminado"), HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {

		if (StringUtils.isBlank(dtoProyecto.getNombreProyecto())) {

			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}

		if (proyectoService.existsByNombreProyecto(dtoProyecto.getNombreProyecto())) {

			return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
		}

		Proyecto proyecto = new Proyecto(dtoProyecto.getNombreProyecto(), dtoProyecto.getDescripcionProyecto(), dtoProyecto.getImagen());
		proyectoService.save(proyecto);
		

		return new ResponseEntity(new Mensaje("Nuevo Proyecto ha sido salvado"), HttpStatus.OK);

	}
	
	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {

		// Validación existencia del id

		if (!proyectoService.existsById(id)) {

			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		}

		// Compara nombre de proyectos

		if (proyectoService.existsByNombreProyecto(dtoProyecto.getNombreProyecto())
				&& proyectoService.getByNombreProyecto(dtoProyecto.getNombreProyecto()).get().getId() != id) {

			return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);

		}

		// No puede estar vacío

		if (StringUtils.isBlank(dtoProyecto.getNombreProyecto())) {

			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		
		// Llegó hasta acá

		Proyecto proyecto = proyectoService.getOne(id).get();
		proyecto.setNombreProyecto(dtoProyecto.getNombreProyecto());
		proyecto.setDescripcionProyecto(dtoProyecto.getDescripcionProyecto());
		proyecto.setImagen(dtoProyecto.getImagen());

		proyectoService.save(proyecto);
		return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

	}
	
	

}
