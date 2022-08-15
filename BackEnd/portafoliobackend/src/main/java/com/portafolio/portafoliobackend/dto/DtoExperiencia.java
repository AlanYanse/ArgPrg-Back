package com.portafolio.portafoliobackend.dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

	@NotBlank
	private String nombreE;

	@NotBlank
	private String descripcionE;

	// Constructores

	public DtoExperiencia() {

	}

	public DtoExperiencia(@NotBlank String nombreE, @NotBlank String descripcionE) {
		super();
		this.nombreE = nombreE;
		this.descripcionE = descripcionE;
	}

	// Getters and Setters

	public String getNombreE() {
		return nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public String getDescripcionE() {
		return descripcionE;
	}

	public void setDescripcionE(String descripcionE) {
		this.descripcionE = descripcionE;
	}

}
