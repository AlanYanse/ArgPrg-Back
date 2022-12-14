package com.portafolio.portafoliobackend.dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {

	@NotBlank
	private String nombreProyecto;

	@NotBlank
	private String descripcionProyecto;

	@NotBlank
	private String imagen;
	
	@NotBlank
	private String enlace;

	// Constructors

	public DtoProyecto() {

	}

	public DtoProyecto(@NotBlank String nombreProyecto, @NotBlank String descripcionProyecto, @NotBlank String imagen, @NotBlank String enlace) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.descripcionProyecto = descripcionProyecto;
		this.imagen = imagen;
		this.enlace = enlace;
	}

	// Getters and Setters

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getEnlace() {
		return this.enlace;
	}
	
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

}
