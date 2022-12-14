package com.portafolio.portafoliobackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombreProyecto;
	private String descripcionProyecto;
	private String imagen;
	private String enlace;
	
	// Constructors
	
	public Proyecto() {
		
	}

	public Proyecto(String nombreProyecto, String descripcionProyecto, String imagen, String enlace) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.descripcionProyecto = descripcionProyecto;
		this.imagen = imagen;
		this.enlace = enlace;
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
