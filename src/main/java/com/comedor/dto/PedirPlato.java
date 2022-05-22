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
@Table(name = "pedirPlato")
public class PedirPlato {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedirPlato")
	private Long idPedirPlato;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idPlato")
	Plato plato;

	@ManyToOne
	@JoinColumn(name = "idFranja")
	Franja franja;

	@OneToMany
	@JoinColumn(name = "idPedirPlato")
	private List<Reserva> reserva;

	// constructores
	public PedirPlato() {

	}

	public PedirPlato(Long idPedirPlato, Usuario usuario, Plato plato, Franja franja, List<Reserva> reserva) {

		this.idPedirPlato = idPedirPlato;
		this.usuario = usuario;
		this.plato = plato;
		this.franja = franja;
		this.reserva = reserva;
	}

	// getters y setters
	public Long getIdPedirPlato() {
		return idPedirPlato;
	}

	public void setIdPedirPlato(Long idPedirPlato) {
		this.idPedirPlato = idPedirPlato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Franja getFranja() {
		return franja;
	}

	public void setFranja(Franja franja) {
		this.franja = franja;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	// método toString
	@Override
	public String toString() {
		return "PedirPlato [idPedirPlato=" + idPedirPlato + ", usuario=" + usuario + ", plato=" + plato + ", franja="
				+ franja + "]";
	}

}
