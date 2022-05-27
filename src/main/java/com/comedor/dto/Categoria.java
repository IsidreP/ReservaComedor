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
@Table(name="categorias")
public class Categoria {
	
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private int idCategoria;
	
	@Column(name = "nombre")
	private String nombreCategoria;
	
	@OneToMany
    @JoinColumn(name="id") 
    private List<Plato> plato;
	
	// constructores
	public Categoria() {
	
	}

	public Categoria(int idCategoria, String nombreCategoria, List<Plato> plato) {
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.plato = plato;
	}

	// setters & getters
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Plato")
	public List<Plato> getPlato() {
		return plato;
	}

	public void setPlato(List<Plato> plato) {
		this.plato = plato;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
}
