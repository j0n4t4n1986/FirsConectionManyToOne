package com.mx.ieepo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ieepo.domain.Alumno;
import com.mx.ieepo.services.AlumnoService;

@RestController
@RequestMapping("alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping(value="{id}")
	public Optional<Alumno> findbyId (@PathVariable(  )Long id) {
		
		return alumnoService.findbyId(id);
	}
	
	@GetMapping(value="")
	public Iterable<Alumno> findAll () {
		return alumnoService.findAll();
	}
	
	@PostMapping(value="")
	public Alumno save (@RequestBody Alumno alumno) {
		return alumnoService.save(alumno);
	}
	
	@PutMapping(value="")
	public Alumno update (@RequestBody Alumno alumno) {
		return alumnoService.update(alumno);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable("id") Long id) {
		alumnoService.delete(id);
	}
	
	@GetMapping(value="finByProfesor/{idProfesor}")
	public List<Alumno> findbyProfesorId (@PathVariable( "idProfesor" )Long id) {
		
		return alumnoService.findbyProfesorId(id);
	}
	
	

}
