package com.portafolio.portafoliobackend.dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
	
	@NotBlank
	private String nombreE;
	
	@NotBlank
	private String descripcionE;
	
	public DtoEducacion() {
		
	}

	public DtoEducacion(@NotBlank String nombreE, @NotBlank String descripcionE) {
		super();
		this.nombreE = nombreE;
		this.descripcionE = descripcionE;
	}

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
