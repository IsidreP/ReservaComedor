package com.comedor.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idUsuario;

	@Column(name = "nombre")
	private String nombreUsuario;

	@Column(name = "email")
	private String email;

	@Column(name = "contrasenya")
	private String contrasenya;

	@ManyToOne
	@JoinColumn(name = "rol")
	Rol rol;

	@OneToMany
	@JoinColumn(name = "id")
	private List<PedirPlato> pedirPlato;

	public Usuario() {

	}

	public Usuario(Long idUsuario, String nombreUsuario, String email, String contrasenya, Rol rol,
			List<PedirPlato> pedirPlato) {

		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenya = contrasenya;
		this.rol = rol;
		this.pedirPlato = pedirPlato;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PedirPlato")
	public List<PedirPlato> getPedirPlato() {
		return pedirPlato;
	}

	public void setPedirPlato(List<PedirPlato> pedirPlato) {
		this.pedirPlato = pedirPlato;
	}

	// método toString
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", email=" + email
				+ ", contrasenya=" + contrasenya + "]";
	}

}