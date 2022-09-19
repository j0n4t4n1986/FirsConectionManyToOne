package com.mx.ieepo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Escuelas")
public class EscuelasController {
	
	
	@GetMapping(value="")
	String regresaMensaje() {
		return "hola";
	}
	

}
