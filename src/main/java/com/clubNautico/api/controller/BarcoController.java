package com.clubNautico.api.controller;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clubNautico.api.dto.BarcoDTO;
import com.clubNautico.api.model.Barco;
import com.clubNautico.api.service.BarcoService;



@RestController
public class BarcoController {

	
	@Autowired
	BarcoService barcoService;
	
	@GetMapping("/barcos")
	public List<BarcoDTO> getBarcos(){
		
		return barcoService.findAllBarcos();
}
	
	@GetMapping("/barco/{matricula}")
	public ResponseEntity<?> getBarco(@PathVariable Integer matricula){
		try {
			BarcoDTO aux = barcoService.getBarco(matricula);
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
}
	
	@PostMapping("/barco")
	public ResponseEntity<?> addBarco(@RequestBody BarcoDTO barco) {
			try {
				System.out.println(barco);
				Barco aux = barcoService.addBarco(barco);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

			}
			
			
		}
	
	@PutMapping("/barco/{matricula}")
	public ResponseEntity<?> updateBarco(@RequestBody BarcoDTO barco,@PathVariable Integer matricula){
		try {
			Barco aux = barcoService.editBarco(barco,matricula);
			
			if(aux == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El barco a editar no existe");
			}else {
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put("msg", "El barco ha sido editado correctamente").toString());
			
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}
	
	@DeleteMapping("/barco/{matricula}")
	public ResponseEntity<?> deleteByMatricula(@PathVariable Integer matricula){
		try {
			barcoService.deleteBarco(matricula);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JSONObject().put("msg", "El barco se a eliminado correctamente").toString());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONObject().put("msg", "Ha ocurrido un error inesperado correctamente").toString());

		}
	}
	
}