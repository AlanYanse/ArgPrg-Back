package com.portafolio.portafoliobackend.dto;

import javax.validation.constraints.NotBlank;

public class DtoSkill {
	
	@NotBlank
	private String nombreSkill;
	
	@NotBlank
	private int percent;
	
	// Constructors
	
	public DtoSkill() {
		
	}

	public DtoSkill(@NotBlank String nombreSkill, @NotBlank int percent) {
		super();
		this.nombreSkill = nombreSkill;
		this.percent = percent;
	}
	
	// Getters and Setters

	public String getNombreSkill() {
		return nombreSkill;
	}

	public void setNombreSkill(String nombreSkill) {
		this.nombreSkill = nombreSkill;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
	

}
