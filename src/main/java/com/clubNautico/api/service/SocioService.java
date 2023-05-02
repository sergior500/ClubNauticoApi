package com.clubNautico.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubNautico.api.dto.SocioDTO;
import com.clubNautico.api.exeption.NotFoundSocioException;
import com.clubNautico.api.model.Socio;
import com.clubNautico.api.repository.SocioRepository;

@Service
public class SocioService {
	
	@Autowired
	SocioRepository socioRepository;
	
	private SocioDTO convertToSocioDTO(Socio socio) {
		SocioDTO aux = new SocioDTO();
		
		aux.setNombre(socio.getNombre());
		aux.setApellido(socio.getApellido());
		aux.setId(socio.getNumSocio());
		
		
		return aux;
	}
	
	private List<SocioDTO> convertToListPatronDto(List<Socio> listSocio) {
			return listSocio.stream().map(this::convertToSocioDTO)
			.collect(Collectors.toList());
			}
	
	public List<SocioDTO> findAllSocios() {
		
		return convertToListPatronDto(socioRepository.findAll());
		
	}
	
	public SocioDTO getSocioDTO(Integer id) {
		Socio socio;
		SocioDTO aux = null;
		
			socio =  socioRepository.getReferenceById(id);
			aux = convertToSocioDTO(socio);
			
			if(socio == null)
				throw new NotFoundSocioException(id);
		
		return aux;
		
	}
	
	public Socio getSocio(Integer id) {
		Socio socio = null;
		
			socio =  socioRepository.getReferenceById(id);
			
			if(socio == null)
				throw new NotFoundSocioException(id);
		
		return socio;
		
	}
	
	public Socio addSocio(Socio socio) {
		
		return	socioRepository.save(socio);


		
	}
	
	public Socio editSocio(Socio socio, Integer id) {
		
		Socio aux = socioRepository.getReferenceById(id);
		
		if(aux.getNumSocio() != socio.getNumSocio()) {
			if(aux.getNombre() != null)
				aux.setNombre(socio.getNombre());
			if(aux.getApellido() != null)
				aux.setApellido(socio.getApellido());
		}
		
		socioRepository.save(aux);
		
		return aux;
	}
	
	public boolean deleteSocio(Integer id) {
		boolean result = false;
		Socio aux = socioRepository.getReferenceById(id);
		
		if (aux != null) {
			socioRepository.delete(aux);
			result = true;
		}
			
		
		return result;
	}
}
