package com.clubNautico.api.controller;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clubNautico.api.dto.SocioDTO;
import com.clubNautico.api.model.Socio;
import com.clubNautico.api.service.SocioService;



@RestController
public class SocioController {

	
	@Autowired
	SocioService socioService;
	
	@GetMapping("/socios")
	public List<SocioDTO> getSocios(){
		
		return socioService.findAllSocios();
}
	
	@GetMapping("/socio/{id}")
	public ResponseEntity<?> getSocios(@PathVariable Integer id){
		try {
			SocioDTO aux = socioService.getSocioDTO(id);
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
}
	
	@PostMapping("/socio")
	public ResponseEntity<?> addSocios(@Validated @RequestBody Socio socio) {
			try {
				Socio aux = socioService.addSocio(socio);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

			}
		}
	
	@PutMapping("/socio/{id}")
	public ResponseEntity<?> updateSocios(@RequestBody Socio socio,@PathVariable Integer id){
		try {
			Socio aux = socioService.editSocio(socio,id);
			
			if(aux == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El socio a editar no existe");
			}else {
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put("msg", "El socio ha sido editado correctamente").toString());
			
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}
	
	@DeleteMapping("/socio/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		try {
			socioService.deleteSocio(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put("msg", "El socio se a eliminado correctamente").toString());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONObject().put("msg", "Ha ocurrido un error inesperado correctamente").toString());

		}
	}
	
}