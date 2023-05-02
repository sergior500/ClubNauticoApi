package com.clubNautico.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name="Socio")
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numSocio;
	@Size(min = 3, max = 13, message = "El nombre tiene que ser mayor a 3 y menor a 13.")
	@NotNull
	@NotBlank
	private String Nombre;
	@Size(min = 3, max = 13, message = "El apellido tiene que ser mayor a 3 y menor a 13.")
	@NotNull
	@NotBlank
	private String Apellido;
	
	@OneToMany(mappedBy = "Duenno")
	private List<Barco> barcos;
	
	public Socio() {

	}
	
	public Socio(String nombre, String apellido) {
		super();
		Nombre = nombre;
		Apellido = apellido;
	}
	
	public Socio(int numSocio, String nombre, String apellido) {
		super();
		this.numSocio = numSocio;
		Nombre = nombre;
		Apellido = apellido;
	}

	public int getNumSocio() {
		return numSocio;
	}

	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + numSocio;
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
		Socio other = (Socio) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (numSocio != other.numSocio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Socio [numSocio=" + numSocio + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}
	
	
	
	
}
