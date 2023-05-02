package com.clubNautico.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubNautico.api.dto.BarcoDTO;
import com.clubNautico.api.exeption.NotFoundBarcoException;
import com.clubNautico.api.exeption.NotFoundSocioException;
import com.clubNautico.api.model.Barco;
import com.clubNautico.api.model.Socio;
import com.clubNautico.api.repository.BarcoRepository;



@Service
public class BarcoService {
	
	@Autowired
	BarcoRepository barcoRepository;
	
	@Autowired
	SocioService socioService ;
	
	private BarcoDTO convertToBarcoDTO(Barco barco) {
		BarcoDTO aux = new BarcoDTO();
		
		
		aux.setCuota(barco.getCuota());
		aux.setNombre(barco.getNombre());
		aux.setNumAmarre(barco.getNumAmarre());
		aux.setIdSocio(barco.getDuenno().getNumSocio());
		aux.setNumMatricula(barco.getNumMatricula());
		
		
		return aux;
	}
	
	private List<BarcoDTO> convertToListBarcoDto(List<Barco> listBarco) {
			return listBarco.stream().map(this::convertToBarcoDTO)
			.collect(Collectors.toList());
			}
	
	
	public List<BarcoDTO> findAllBarcos() {
		
		return convertToListBarcoDto(barcoRepository.findAll());
		
	}
	
	public BarcoDTO getBarco(Integer id) {
		Barco barco;
		BarcoDTO aux = null;

		barco =  barcoRepository.getReferenceById(id);
		aux = convertToBarcoDTO(barco);
		
		if(barco == null) 
			throw new NotFoundBarcoException(id);

		return aux;
		
	}
	
	public Barco addBarco(BarcoDTO barco) {
		Socio socioAux = socioService.getSocio(barco.getIdSocio());
		System.out.println(barco);
		if (socioAux == null)
			throw new NotFoundSocioException(barco.getIdSocio());
		
		Barco aux = new Barco(barco.getNombre(), barco.getNumAmarre(), barco.getCuota(), socioAux);
		
		return barcoRepository.save(aux);
			
		
	}
	
	public Barco editBarco(BarcoDTO barco, Integer id) {
		
		Barco aux = barcoRepository.getReferenceById(id);
		if (aux == null)
			throw new NotFoundBarcoException(id);
		
		Socio socioAux = socioService.getSocio(barco.getIdSocio());
		if (socioAux == null)
			throw new NotFoundSocioException(barco.getIdSocio());
		
		
		if(barco.getCuota() != null)
			aux.setCuota(barco.getCuota());
		if(barco.getIdSocio() != null)
			aux.setDuenno(socioAux);
		if(barco.getNombre() != null)
			aux.setNombre(barco.getNombre());
		if(barco.getNumAmarre() != null)
			aux.setNumAmarre(barco.getNumAmarre());
		
		
		barcoRepository.save(aux);
		
		return aux;
	}
	
	public boolean deleteBarco(Integer id) {
		boolean result = false;
		Barco aux = barcoRepository.getReferenceById(id);
		
		if (aux != null) {
			barcoRepository.delete(aux);
			result = true;
		}
			
		
		return result;
	}
}
