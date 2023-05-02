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

import com.clubNautico.api.dto.PatronDTO;
import com.clubNautico.api.model.Patron;
import com.clubNautico.api.service.PatronService;



@RestController
public class PatronController {

	
	@Autowired
	PatronService patronService;
	
	@GetMapping("/patrones")
	public List<PatronDTO> getPatrones(){
		
		return patronService.findAllPatrones();
}
	
	@GetMapping("/patron/{id}")
	public ResponseEntity<?> getPatron(@PathVariable Integer id){
		try {
			PatronDTO aux = patronService.getPatron(id);
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
}
	
	@PostMapping("/patron")
	public ResponseEntity<?> addPatron(@Validated @RequestBody Patron patron) {
			try {
				Patron aux = patronService.addPatron(patron);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

			}
		}
	
	@PutMapping("/patron/{id}")
	public ResponseEntity<?> updatePatron(@RequestBody Patron patron,@PathVariable Integer id){
		try {
			Patron aux = patronService.editPatron(patron,id);
			
			if(aux == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El patron a editar no existe");
			}else {
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put("msg", "El patron ha sido editado correctamente").toString());
			
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}
	
	@DeleteMapping("/patron/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		try {
			patronService.deletePatron(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put("msg", "El patron se a eliminado correctamente").toString());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONObject().put("msg", "Ha ocurrido un error inesperado correctamente").toString());

		}
	}
	
}