package com.portafolio.portafoliobackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreSkill;
	private String descripcionSkill;
	private String img;
	private int percent;
	
	// Constructors
	
	public Skill() {
		
	}

	public Skill(String nombreSkill, String descripcionSkill, String img,  int percent) {
		super();
		this.nombreSkill = nombreSkill;
		this.descripcionSkill = descripcionSkill;
		this.img = img;
		this.percent = percent;
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}
	
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

	public void setId(int id) {
		this.id = id;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
	
	
	

}
