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
@Table(name = "platos")
public class Plato {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // FALTABA
	private int idPlato;

	@Column(name = "nombre")
	private String nombrePlato;

	@Column(name = "descripcion")
	private String descripcionPlato;

	@Column(name = "imagen")
	private String imagenPlato;

	@Column(name = "precio")
	private float precioPlato;

	@OneToMany
	@JoinColumn(name = "id") 
	private List<PedirPlato> pedirPlato;

	@ManyToOne
	@JoinColumn(name = "categoria")
	Categoria categoria;

	// constructores
	public Plato() {

	}

	public Plato(int idPlato, String nombrePlato, String descripcionPlato, String imagenPlato, float precioPlato,
			List<PedirPlato> pedirPlato, Categoria categoria) {

		this.idPlato = idPlato;
		this.nombrePlato = nombrePlato;
		this.descripcionPlato = descripcionPlato;
		this.imagenPlato = imagenPlato;
		this.precioPlato = precioPlato;
		this.pedirPlato = pedirPlato;
		this.categoria = categoria;
	}

	// getters y setters
	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public String getDescripcionPlato() {
		return descripcionPlato;
	}

	public void setDescripcionPlato(String descripcionPlato) {
		this.descripcionPlato = descripcionPlato;
	}

	public String getImagenPlato() {
		return imagenPlato;
	}

	public void setImagenPlato(String imagenPlato) {
		this.imagenPlato = imagenPlato;
	}

	public float getPrecioPlato() {
		return precioPlato;
	}

	public void setPrecioPlato(float precioPlato) {
		this.precioPlato = precioPlato;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PedirPlato")
	public List<PedirPlato> getPedirPlato() {
		return pedirPlato;
	}

	public void setPedirPlato(List<PedirPlato> pedirPlato) {
		this.pedirPlato = pedirPlato;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
