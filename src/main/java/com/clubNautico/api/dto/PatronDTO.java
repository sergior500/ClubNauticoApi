package com.clubNautico.api.dto;

import java.util.Objects;

public class PatronDTO {
	
	private Integer Id;
	private String Nombre;
	private String Apellido;
	
	public PatronDTO() {

	}
	
	public PatronDTO(String nombre, String apellido,Integer id) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Id = id;
	}
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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
		return Objects.hash(Apellido, Id, Nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatronDTO other = (PatronDTO) obj;
		return Objects.equals(Apellido, other.Apellido) && Objects.equals(Id, other.Id)
				&& Objects.equals(Nombre, other.Nombre);
	}
	

	
	
	
}
