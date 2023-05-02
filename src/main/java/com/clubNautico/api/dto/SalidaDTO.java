package com.clubNautico.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;


public class SalidaDTO {
	@NotNull
	private Integer NumMatricula;
	@NotNull
	private Integer IdPatron;
	
	private LocalDateTime fecha;
	
	
	public SalidaDTO() {
		super();

	}
	
	public SalidaDTO(@NotNull Integer numMatricula, @NotNull Integer idPatron) {
		super();
		NumMatricula = numMatricula;
		IdPatron = idPatron;
	}
	
	public Integer getNumMatricula() {
		return NumMatricula;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
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

	@Override
	public int hashCode() {
		return Objects.hash(IdPatron, NumMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalidaDTO other = (SalidaDTO) obj;
		return Objects.equals(IdPatron, other.IdPatron) && Objects.equals(NumMatricula, other.NumMatricula);
	}
	
	
	
}
