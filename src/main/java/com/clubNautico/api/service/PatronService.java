package com.clubNautico.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubNautico.api.dto.PatronDTO;
import com.clubNautico.api.exeption.NotFoundPatronException;
import com.clubNautico.api.model.Patron;
import com.clubNautico.api.repository.PatronRepository;


@Service
public class PatronService {
	
	@Autowired
	PatronRepository patronRepository;
	
	private PatronDTO convertToPatronDTO(Patron patron) {
		PatronDTO aux = new PatronDTO();
		
		aux.setNombre(patron.getNombre());
		aux.setApellido(patron.getApellido());
		aux.setId(patron.getIdPatron());
		
		
		return aux;
	}
	
	
	private List<PatronDTO> convertToListPatronDto(List<Patron> listPatron) {
			return listPatron.stream().map(this::convertToPatronDTO)
			.collect(Collectors.toList());
			}
	
	
	public List<PatronDTO> findAllPatrones() {
		
		List<PatronDTO> list = convertToListPatronDto(patronRepository.findAll());
		
		if(list ==  null)
			throw new NotFoundPatronException();
		
		return list;
		
	}
	
	public PatronDTO getPatron(Integer id) {
		Patron patron;
		PatronDTO aux = null;
		
		patron =  patronRepository.getReferenceById(id);
		aux = convertToPatronDTO(patron);
			
		if(patron == null) 
			throw new NotFoundPatronException(id);
		
		
		return aux;
		
	}
	
	public Patron addPatron(Patron patron) {
		
		return patronRepository.save(patron);

	}
	
	public Patron editPatron(Patron patron, Integer id) {
		
		Patron aux = patronRepository.getReferenceById(id);
		
		if(aux.getIdPatron() != patron.getIdPatron()) {
			if(patron.getNombre() != null)
				aux.setNombre(patron.getNombre());
			if(patron.getApellido() != null)
				aux.setApellido(patron.getApellido());
			
		}
		
		patronRepository.save(aux);
		
		return aux;
	}
	
	public boolean deletePatron(Integer id) {
		boolean result = false;
		Patron aux = patronRepository.getReferenceById(id);
		
		if (aux != null) {
			patronRepository.delete(aux);
			result = true;
		}
			
		
		return result;
	}
}
