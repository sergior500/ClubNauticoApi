package com.clubNautico.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
@IdClass(Salida_id.class)
public class Salida {
	
	@Id
	@ManyToOne
	@JoinColumn(
			name = "NumMatricula"
			)
	private Barco NumMatricula;
	
	@Id
	@ManyToOne
	@JoinColumn(
			name = "IdPatron"
			)
	private Patron IdPatron;
	
	@Id
	private LocalDateTime fecha;
	
	public Salida() {

	}
	
	public Salida(Barco numMatricula, Patron idPatron, LocalDateTime fecha) {
		super();
		NumMatricula = numMatricula;
		IdPatron = idPatron;
		this.fecha = fecha;
	}

	public Barco getNumMatricula() {
		return NumMatricula;
	}

	public void setNumMatricula(Barco numMatricula) {
		NumMatricula = numMatricula;
	}

	public Patron getIdPatron() {
		return IdPatron;
	}

	public void setIdPatron(Patron idPatron) {
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
		Salida other = (Salida) obj;
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
		return true;
	}
	
	
	
	
}
