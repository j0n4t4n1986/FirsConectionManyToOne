package com.mx.ieepo.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mx.ieepo.domain.Profesor;


public interface ProfesorRespository extends CrudRepository<Profesor, Long>{
	
	Optional<Profesor> findById(Long id);
	Profesor findByDireccionAndEdad(String direccion, Integer edad);
	Profesor findByDireccionOrEdad(String direccion, Integer edad);
	
	Profesor findByEdadBetweenAndNombre(Integer edad1,Integer edad2,String nombre);
	
	/*@Query
	Optional<Profesor> findxDato(Long id);*/
	/*
	 * 
	 *  */
	//@Query(value="select p.* from profesor p where p.nombre = :nombre and edad:=edad", nativeQuery = true)
	//listas findAllBy
	//solo uno findBy
	
	
	Profesor findAllByNombreAndEdad(String nombre, Integer edad);
	List<Profesor> findAllByNombre(String nombre);
	Profesor findByNombre(String nombre);
	Profesor findByDireccion(String nombre);
	
	
	
	Profesor findByEdad(Integer edad);
	
	@Query ("select p from Profesor p where p.edad= :edad")
	Profesor findByQueryProfesorEdadPsql(@Param("edad") Integer age);
	//ejemplo sql
	@Query(value="select p.* from profesor p where p.edad = :edad", nativeQuery = true)
	Profesor findByQueryProfesorEdadSql (@Param("edad") Integer edad);
	
	
	
}
