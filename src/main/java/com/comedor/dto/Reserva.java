package com.comedor.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReserva")
	private Long idReserva;

	@Column(name = "fechaReservada")
	private Date fechaReservada; 

	@Column(name = "precioTotal")
	private float precioTotal;

	@ManyToOne
	@JoinColumn(name = "idPedirPlato")
	PedirPlato pedirPlato;

	// constructores
	public Reserva() {

	}

	public Reserva(Long idReserva, Date fechaReservada, float precioTotal, PedirPlato pedirPlato) {

		this.idReserva = idReserva;
		this.fechaReservada = fechaReservada;
		this.precioTotal = precioTotal;
		this.pedirPlato = pedirPlato;
	}

	// getters y setters
	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaReservada() {
		return fechaReservada;
	}

	public void setFechaReservada(Date fechaReservada) {
		this.fechaReservada = fechaReservada;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public PedirPlato getPedirPlato() {
		return pedirPlato;
	}

	public void setPedirPlato(PedirPlato pedirPlato) {
		this.pedirPlato = pedirPlato;
	}

	// método toString
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", fechaReservada=" + fechaReservada + ", precioTotal=" + precioTotal
				+ "]";
	}

}
