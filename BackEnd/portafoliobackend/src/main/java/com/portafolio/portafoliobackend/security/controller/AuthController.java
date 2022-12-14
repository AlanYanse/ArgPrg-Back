package com.portafolio.portafoliobackend.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.portafoliobackend.entity.Persona;
import com.portafolio.portafoliobackend.security.dto.JwtDto;
import com.portafolio.portafoliobackend.security.dto.LoginUsuario;
import com.portafolio.portafoliobackend.security.dto.NuevoUsuario;
import com.portafolio.portafoliobackend.security.entity.Rol;
import com.portafolio.portafoliobackend.security.entity.Usuario;
import com.portafolio.portafoliobackend.security.enums.RolNombre;
import com.portafolio.portafoliobackend.security.jwt.JwtProvider;
import com.portafolio.portafoliobackend.security.service.RolService;
import com.portafolio.portafoliobackend.security.service.UsuarioService;

@RestController
@RequestMapping("/auth")
//Deploy https://frontendportafolio.web.app
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RolService rolService;
	@Autowired
	JwtProvider jwtProvider;
	
	
	// Creaci??n de usuario
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);

		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);

		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);

		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);

		return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
	}
	
	
	// Eliminaci??n de usuario
	
	@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id){
		usuarioService.deleteUser(id);
        return "El usuario ha sido eliminado correctamente";
    }
    
  

	// Login
	
	

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}

}
