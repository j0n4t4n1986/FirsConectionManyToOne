package com.mx.ieepo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.mx.ieepo.domain.Profesor;
import com.mx.ieepo.dto.Responsedto;
import com.mx.ieepo.respository.ProfesorRespository;

@Component
public class ProfesorService {
	
	@Autowired
	private ProfesorRespository profesorRespository;
	
	public Optional<Profesor> findbyId(Long id) {
		return profesorRespository.findById(id);
		
	}
	
	public Iterable<Profesor> findAll() {
		return profesorRespository.findAll();
		
	}
	
	public Profesor save(Profesor profesor) {
		return profesorRespository.save(profesor);
		
	}
	
	public Profesor update(Profesor profesor) {
		return profesorRespository.save(profesor);
		
	}
	
	public void delete(Long id) {
		System.out.println("se eliminara el ID: " + id.toString());
		profesorRespository.deleteById(id);
		
	}
	
	public Profesor findByName(String name) {
		return profesorRespository.findByNombre(name);
	}
	
	public List<Profesor> findAllByNombre(String name) {
		
		return profesorRespository.findAllByNombre(name);
	}
	
	public Responsedto findByEdadQuerySql(Integer edad) {
		
		Responsedto responsedto= new Responsedto();
		Profesor profesor = new Profesor();
		profesor=profesorRespository.findByQueryProfesorEdadSql(edad);
		responsedto.setBody(profesor);
		responsedto.setStatus(HttpStatus.OK);
		if (profesor != null)
			responsedto.setMessage("se encontraron coinsidencias");
		else
			responsedto.setMessage("no existen coinsidencias");
		
		return responsedto;
	}
}
