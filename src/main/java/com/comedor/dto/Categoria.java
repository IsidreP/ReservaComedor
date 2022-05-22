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
import com.comedor.dto.Plato;

@Entity
@Table(name="categorias")//en caso que la tabala sea diferente
public class Categoria {
	
	//Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "nombreCategoria")//no hace falta si se llama igual
	private String nombreCategoria;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Plato> plato;
	
	//Constructores
	
	public Categoria() {
	
	}

	/**
	 * @param id
	 * @param nombreCategoria
	 */
	public Categoria(int id, String nombreCategoria, List<Plato> plato) {
		super();
		this.id = id;
		this.nombreCategoria = nombreCategoria;
		this.plato = plato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	/**
	 * @return the registroCurso
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Plato")
	public List<Plato> getSuministra() {
		return plato;
	}

	/**
	 * @param registroCurso the registroCurso to set
	 */
	public void setPlato(List<Plato> plato) {
		this.plato = plato;
	}
	

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombreCategoria=" + nombreCategoria + ", plato=" + plato + "]";
	}





}
