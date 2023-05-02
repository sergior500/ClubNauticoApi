package com.clubNautico.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubNautico.api.dto.SalidaDTO;
import com.clubNautico.api.model.Salida;

import com.clubNautico.api.repository.BarcoRepository;
import com.clubNautico.api.repository.PatronRepository;
import com.clubNautico.api.repository.SalidaRepository;


@Service
public class SalidaService {
	
	@Autowired
	SalidaRepository salidaRepository;
	
	@Autowired
	PatronRepository patronRepository;
	
	@Autowired
	BarcoRepository barcoRepository;
	
	private Salida convertToSalida(SalidaDTO salida) {
		Salida aux = new Salida(barcoRepository.getReferenceById(salida.getNumMatricula()),patronRepository.getReferenceById(salida.getIdPatron()),LocalDateTime.now());
		
		return aux;
	}
	
	
	public List<Salida> findAllSalidas() {
		
		return salidaRepository.findAll();
		
	}
	
	public Salida addSalida(SalidaDTO salida) {

	return salidaRepository.save(convertToSalida(salida));
	 
		
	}
	
}
