package com.comedor.dto;

import java.util.List;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="Rol")//en caso que la tabala sea diferente

public class Rol {

	//Atributos de entidad equipo
	@Id
	private int id;
	@Column(name = "nombreRol")
	private String nombreRol;
	
	//Constructores
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Usuario> usuarios;
	

	
	public Rol() {
	
	}

	
	public Rol(int id, String nombre) {
		//super();
		this.id = id;
		this.nombreRol = nombre;
			
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombreRol() {
		return nombreRol;
	}


	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuarios")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombreRol=" + nombreRol + ", usuarios=" + usuarios + "]";
	}


	
	
	
}
