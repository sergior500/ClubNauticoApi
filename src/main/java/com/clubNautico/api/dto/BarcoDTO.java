package com.clubNautico.api.dto;

import java.util.Objects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BarcoDTO {
	@NotNull
	private Integer NumMatricula;
	@NotNull
	@NotBlank
	private String Nombre;
	@Min(value = 0, message = "El numero de amarre tiene que ser mayor que 0.")
	private Integer NumAmarre;
	@Min(value = 0, message = "La cuota tiene que ser mayor que 0.")
	private Integer Cuota;
	private Integer IdSocio;
	
	public BarcoDTO() {

	}
	
	public BarcoDTO(Integer numMatricula,String nombre, Integer numAmarre, Integer cuota, Integer idSocio) {
		super();
		Nombre = nombre;
		NumAmarre = numAmarre;
		Cuota = cuota;
		IdSocio = idSocio;
		NumMatricula = numMatricula;
	}
	
	public Integer getNumMatricula() {
		return NumMatricula;
	}

	public void setNumMatricula(Integer numMatricula) {
		NumMatricula = numMatricula;
	}

	public Integer getIdSocio() {
		return IdSocio;
	}

	public void setIdSocio(Integer idSocio) {
		IdSocio = idSocio;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Integer getNumAmarre() {
		return NumAmarre;
	}
	public void setNumAmarre(Integer numAmarre) {
		NumAmarre = numAmarre;
	}
	public Integer getCuota() {
		return Cuota;
	}
	public void setCuota(Integer cuota) {
		Cuota = cuota;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(Cuota, IdSocio, Nombre, NumAmarre, NumMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarcoDTO other = (BarcoDTO) obj;
		return Objects.equals(Cuota, other.Cuota) && Objects.equals(IdSocio, other.IdSocio)
				&& Objects.equals(Nombre, other.Nombre) && Objects.equals(NumAmarre, other.NumAmarre)
				&& Objects.equals(NumMatricula, other.NumMatricula);
	}

	@Override
	public String toString() {
		return "BarcoDTO [Nombre=" + Nombre + ", NumAmarre=" + NumAmarre + ", Cuota=" + Cuota + ", IdSocio=" + IdSocio
				+ "]";
	}


	
	
	
	
}
