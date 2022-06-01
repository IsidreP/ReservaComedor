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
	private Long id;

	@Column(name = "nombre")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "contrasenya")
	private String password;

	@ManyToOne
	@JoinColumn(name = "rol")
	Rol rol;

	@OneToMany
	@JoinColumn(name = "id")
	private List<PedirPlato> pedirPlato;

	public Usuario() {

	}

	public Usuario(Long id, String username, String email, String password, Rol rol,
			List<PedirPlato> pedirPlato) {

		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.pedirPlato = pedirPlato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

//	// método toString
//	@Override
//	public String toString() {
//		return "Usuario [id=" + id + ", username=" + username + ", email=" + email
//				+ ", password=" + password + "]";
//	}

}