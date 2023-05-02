package com.clubNautico.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Patron {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPatron;
	@Size(min = 3, max = 13, message = "El nombre tiene que ser mayor a 3 y menor a 13.")
	@NotNull
	@NotBlank
	private String Nombre;
	@Size(min = 3, max = 13, message = "El apellido tiene que ser mayor a 3 y menor a 13.")
	@NotNull
	@NotBlank
	private String Apellido;
	
	@OneToMany(mappedBy= "IdPatron")
	@JsonIgnore
	private List<Salida> listSalida;
	
	public Patron() {

	}
	
	
	public Patron(Integer idPatron, String nombre, String apellido) {
		super();
		IdPatron = idPatron;
		Nombre = nombre;
		Apellido = apellido;
	}
	
	public Patron(String nombre, String apellido) {
		super();
		Nombre = nombre;
		Apellido = apellido;
	}

	public Integer getIdPatron() {
		return IdPatron;
	}

	public void setIdPatron(Integer idPatron) {
		IdPatron = idPatron;
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
		result = prime * result + ((IdPatron == null) ? 0 : IdPatron.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Patron other = (Patron) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
		if (IdPatron == null) {
			if (other.IdPatron != null)
				return false;
		} else if (!IdPatron.equals(other.IdPatron))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	
	
	
}
