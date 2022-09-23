package com.mx.ieepo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.ieepo.enums.EdoCivil;

@Entity
//@Table(name="catedratico")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer edad;
	private String direccion;
	
	private EdoCivil estadoCivil;
	
	@JsonIgnore
	@OneToMany(mappedBy="profesor")
	List<Alumno> alumnoList= new ArrayList<Alumno>();
	
	public EdoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EdoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public List<Alumno> getAlumnoList() {
		return alumnoList;
	}
	public void setAlumnoList(List<Alumno> alumnoList) {
		this.alumnoList = alumnoList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
