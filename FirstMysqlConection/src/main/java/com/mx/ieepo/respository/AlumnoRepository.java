package com.mx.ieepo.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mx.ieepo.domain.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
	
	List<Alumno> findAllByProfesorId(Long id);
	
	List<Alumno> findAllByProfesorIdAndProfesorNombre(Long id, String nombre);
	

}
