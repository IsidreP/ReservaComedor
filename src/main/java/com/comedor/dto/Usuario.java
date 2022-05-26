package com.comedor.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")//en caso que la tabala sea diferente
public class Usuario {

	//Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "nombreUsuario")//no hace falta si se llama igual
	private String nombreUsuario;
	@Column(name = "email")//no hace falta si se llama igual
	private String email;
	@Column(name = "contraseña")//no hace falta si se llama igual
	private String contraseña;
	
	//Constructores
	
	@ManyToOne
    @JoinColumn(name="roles_id")
    private Rol roles_id;
	
	
	
	public Usuario() {
	
	}


	public Usuario(int id,String nombreUsuario, String email, String contraseña, Rol roles_id) {
		//super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contraseña = contraseña;
		this.roles_id = roles_id;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public Rol getRoles_id() {
		return roles_id;
	}


	public void setRoles_id(Rol roles_id) {
		this.roles_id = roles_id;
	}
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombreUsuario=" + nombreUsuario + ", email=" + email + ", contraseña="
				+ contraseña + ", roles_id=" + roles_id + "]";
	}
}