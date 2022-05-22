package com.comedor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.comedor.dto.Categoria;
import com.comedor.dto.PedirPlato;

@Entity
@Table(name="platos")//en caso que la tabala sea diferente
public class Plato {
	
	//Atributos de entidad registro_curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int idPlato;
	
	@OneToMany
    @JoinColumn(name = "idPedirPlato")
	PedirPlato pedirPlato;
 
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categoria categoria;
	
	@Column(name = "nombrePlato")//no hace falta si se llama igual
	private String nombrePlato;
	
	@Column(name = "descripcionPlato")//no hace falta si se llama igual
	private String descripcionPlato;
	
	@Column(name = "imagenPlato")//no hace falta si se llama igual
	private String imagenPlato;
	
	@Column(name = "precioPlato")//no hace falta si se llama igual
	private float precioPlato;
	
	//Constructores
	
	public Plato() {
	
	}

	public Plato(int idPlato, PedirPlato pedirPlato, Categoria categoria, String nombrePlato, String descripcionPlato, String imagenPlato, float precioPlato) {
		this.idPlato = idPlato;
		this.pedirPlato = pedirPlato;
		this.categoria = categoria;
		this.nombrePlato = nombrePlato;
		this.descripcionPlato = descripcionPlato;
		this.imagenPlato = imagenPlato;
		this.precioPlato = precioPlato;
	}


	//Getters y Setters
	
	
	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public PedirPlato getPedirPlato() {
		return pedirPlato;
	}

	public void setPedirPlato(PedirPlato pedirPlato) {
		this.pedirPlato = pedirPlato;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", pedirPlato=" + pedirPlato + ", categoria=" + categoria
				+ ", nombrePlato=" + nombrePlato + ", descripcionPlato=" + descripcionPlato + ", imagenPlato="
				+ imagenPlato + ", precioPlato=" + precioPlato + "]";
	}



	
	
	

}
