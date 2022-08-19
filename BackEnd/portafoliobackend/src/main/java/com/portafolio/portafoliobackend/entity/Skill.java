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
	private int percent;
	
	// Constructors
	
	public Skill() {
		
	}

	public Skill(String nombreSkill, int percent) {
		super();
		this.nombreSkill = nombreSkill;
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
