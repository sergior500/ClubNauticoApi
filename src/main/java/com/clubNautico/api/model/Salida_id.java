package com.clubNautico.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Salida_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6402570502764190767L;
	
	private Integer NumMatricula;
	private Integer IdPatron;
	private LocalDateTime fecha;
	
	public Salida_id() {

	}
	
	public Salida_id(Integer numMatricula, Integer idPatron, LocalDateTime fecha) {
		super();
		NumMatricula = numMatricula;
		IdPatron = idPatron;
		this.fecha = fecha;
	}
	
	public Integer getNumMatricula() {
		return NumMatricula;
	}
	public void setNumMatricula(Integer numMatricula) {
		NumMatricula = numMatricula;
	}
	public Integer getIdPatron() {
		return IdPatron;
	}
	public void setIdPatron(Integer idPatron) {
		IdPatron = idPatron;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdPatron == null) ? 0 : IdPatron.hashCode());
		result = prime * result + ((NumMatricula == null) ? 0 : NumMatricula.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salida_id other = (Salida_id) obj;
		if (IdPatron == null) {
			if (other.IdPatron != null)
				return false;
		} else if (!IdPatron.equals(other.IdPatron))
			return false;
		if (NumMatricula == null) {
			if (other.NumMatricula != null)
				return false;
		} else if (!NumMatricula.equals(other.NumMatricula))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
	
	
}
