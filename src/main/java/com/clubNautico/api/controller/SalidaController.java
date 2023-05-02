package com.clubNautico.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clubNautico.api.dto.SalidaDTO;
import com.clubNautico.api.model.Salida;
import com.clubNautico.api.service.SalidaService;

@RestController
public class SalidaController {
	
	@Autowired
	SalidaService salidaService;
	
	@GetMapping("/salidas")
	public List<Salida> getPatrones(){
		
		return salidaService.findAllSalidas();
}

	@PostMapping("/salidas")
	public ResponseEntity<?> addSalida(@RequestBody SalidaDTO salida) {
		try {
			System.out.println(salida);
			Salida aux = salidaService.addSalida(salida);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
		
		
	} 
	
}
