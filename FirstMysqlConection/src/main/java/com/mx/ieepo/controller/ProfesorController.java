package com.mx.ieepo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ieepo.domain.Profesor;
import com.mx.ieepo.dto.Responsedto;
import com.mx.ieepo.services.ProfesorService;

@RestController
@RequestMapping("profesor")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;

	
	@GetMapping(value="{id}")
	public Optional<Profesor> findbyId (@PathVariable(  )Long id) {
		
		return profesorService.findbyId(id);
	}
	
	@GetMapping(value="")
	public Iterable<Profesor> findAll () {
		return profesorService.findAll();
	}
	
	@PostMapping(value="")
	public Profesor save (@RequestBody Profesor profesor) {
		return profesorService.save(profesor);
	}
	
	@PutMapping(value="")
	public Profesor update (@RequestBody Profesor profesor) {
		return profesorService.update(profesor);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable("id") Long id) {
		profesorService.delete(id);
	}
	
	@GetMapping(value="findByName")
	public List<Profesor> findByName (@RequestParam(name = "name") String name) {
		//return profesorService.findByName(name);
		return profesorService.findAllByNombre(name);
	}
	
	@GetMapping(value="findByEdadQuerySql")
	public ResponseEntity<Responsedto>  findByEdadQuerySql (@RequestParam(name = "edad") Integer edad) {
		//return profesorService.findByName(name);
		
		try {
			return new ResponseEntity<>(profesorService.findByEdadQuerySql(edad), HttpStatus.OK);
		} catch (Error e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
