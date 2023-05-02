package com.clubNautico.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity(name = "Barco")
public class Barco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer NumMatricula;
	private String Nombre;
	private Integer NumAmarre;
	private Integer Cuota;
	
	@ManyToOne
	@JoinColumn(name = "Dueño")
	private Socio Duenno;
	
	@OneToMany(mappedBy= "NumMatricula")
	private List<Salida> listSalida;
	
	public Barco() {

	}
	
	public Barco(String nombre, Integer numAmarre, Integer cuota, Socio duenno) {
		super();
		Nombre = nombre;
		NumAmarre = numAmarre;
		Cuota = cuota;
		Duenno = duenno;
	}
	
	public Barco(Integer numMatricula, String nombre, Integer numAmarre, Integer cuota, Socio duenno) {
		super();
		NumMatricula = numMatricula;
		Nombre = nombre;
		NumAmarre = numAmarre;
		Cuota = cuota;
		Duenno = duenno;
	}

	public Integer getNumMatricula() {
		return NumMatricula;
	}

	public void setNumMatricula(Integer numMatricula) {
		NumMatricula = numMatricula;
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

	public Socio getDuenno() {
		return Duenno;
	}

	public void setDuenno(Socio duenno) {
		Duenno = duenno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cuota == null) ? 0 : Cuota.hashCode());
		result = prime * result + ((Duenno == null) ? 0 : Duenno.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((NumAmarre == null) ? 0 : NumAmarre.hashCode());
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
		Barco other = (Barco) obj;
		if (Cuota == null) {
			if (other.Cuota != null)
				return false;
		} else if (!Cuota.equals(other.Cuota))
			return false;
		if (Duenno == null) {
			if (other.Duenno != null)
				return false;
		} else if (!Duenno.equals(other.Duenno))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (NumAmarre == null) {
			if (other.NumAmarre != null)
				return false;
		} else if (!NumAmarre.equals(other.NumAmarre))
			return false;
		if (NumMatricula == null) {
			if (other.NumMatricula != null)
				return false;
		} else if (!NumMatricula.equals(other.NumMatricula))
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		return "Barco [NumMatricula=" + NumMatricula + ", Nombre=" + Nombre + ", NumAmarre=" + NumAmarre + ", Cuota="
				+ Cuota + ", Duenno=" + Duenno + "]";
	}
	
	
}
