package com.mx.ieepo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.ieepo.domain.Alumno;
import com.mx.ieepo.respository.AlumnoRepository;

@Component
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public Optional<Alumno> findbyId(Long id) {
		return alumnoRepository.findById(id);
		
	}
	
	public Iterable<Alumno> findAll() {
		return alumnoRepository.findAll();
		
	}
	
	public Alumno save(Alumno alumno) {
		return alumnoRepository.save(alumno);
		
	}
	
	public Alumno update(Alumno alumno) {
		return alumnoRepository.save(alumno);
		
	}
	
	public void delete(Long id) {
		System.out.println("se eliminara el ID: " + id.toString());
		alumnoRepository.deleteById(id);
		
	}
	
	public List<Alumno> findbyProfesorId(Long ProfesorId){
		return alumnoRepository.findAllByProfesorId(ProfesorId);
	}

}
