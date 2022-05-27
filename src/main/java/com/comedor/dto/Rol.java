package com.comedor.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Rol {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idRol;

	@Column(name = "nombre")
	private String nombreRol;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Usuario> usuario;

	// constructores
	public Rol() {

	}

	public Rol(Long idRol, String nombreRol) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}

	// getters y setters
	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	// método toString
	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
	}
	
}
