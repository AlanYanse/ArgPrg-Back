package com.portafolio.portafoliobackend.dto;

import javax.validation.constraints.NotBlank;

public class DtoSkill {
	
	@NotBlank
	private String nombreSkill;
	
	@NotBlank
	private String descripcionSkill;
	
	@NotBlank
	private String img;
	
	@NotBlank
	private String colorBarrita;
	
	@NotBlank
	private int percent;
	
	// Constructors
	
	public DtoSkill() {
		
	}

	public DtoSkill(@NotBlank String nombreSkill, @NotBlank String descripcionSkill, @NotBlank String img, @NotBlank String colorBarrita,  @NotBlank int percent) {
		super();
		this.nombreSkill = nombreSkill;
		this.descripcionSkill = descripcionSkill;
		this.img = img;
		this.colorBarrita = colorBarrita;
		this.percent = percent;
	}
	
	// Getters and Setters

	public String getNombreSkill() {
		return nombreSkill;
	}

	public void setNombreSkill(String nombreSkill) {
		this.nombreSkill = nombreSkill;
	}
	
	public String getDescripcionSkill() {
		return descripcionSkill;
	}

	public void setDescripcionSkill(String descripcionSkill) {
		this.descripcionSkill = descripcionSkill;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getColorBarrita() {
		return this.colorBarrita;
	}
	
	public void setColorBarrita(String colorBarrita) {
		this.colorBarrita = colorBarrita;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
	

}
