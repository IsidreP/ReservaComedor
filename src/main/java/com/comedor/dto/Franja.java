package com.comedor.dto;

import java.sql.Time;
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
@Table(name = "franjas")
public class Franja {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFranja")
	private Long idFranja;

	@Column(name = "inicioFranja")
	private Time inicioFranja; // importando la librería java.util.Date

	@Column(name = "finFranja")
	private Time finFranja;

	@Column(name = "ocupacionMaxima")
	private int ocupacionMaxima;

	@OneToMany
	@JoinColumn(name = "idFranja")
	private List<PedirPlato> pedirPlato;

	// constructores
	public Franja() {
	}

	public Franja(Long idFranja, Time inicioFranja, Time finFranja, int ocupacionMaxima, List<PedirPlato> pedirPlato) {

		this.idFranja = idFranja;
		this.inicioFranja = inicioFranja;
		this.finFranja = finFranja;
		this.ocupacionMaxima = ocupacionMaxima;
		this.pedirPlato = pedirPlato;
	}

	// getters y setters
	public Long getIdFranja() {
		return idFranja;
	}

	public void setIdFranja(Long idFranja) {
		this.idFranja = idFranja;
	}

	public Time getInicioFranja() {
		return inicioFranja;
	}

	public void setInicioFranja(Time inicioFranja) {
		this.inicioFranja = inicioFranja;
	}

	public Time getFinFranja() {
		return finFranja;
	}

	public void setFinFranja(Time finFranja) {
		this.finFranja = finFranja;
	}

	public int getOcupacionMaxima() {
		return ocupacionMaxima;
	}

	public void setOcupacionMaxima(int ocupacionMaxima) {
		this.ocupacionMaxima = ocupacionMaxima;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PedirPlato")
	public List<PedirPlato> getPedirPlato() {
		return pedirPlato;
	}

	public void setPedirPlato(List<PedirPlato> pedirPlato) {
		this.pedirPlato = pedirPlato;
	}

	// métodotoString
	@Override
	public String toString() {
		return "Franja [idFranja=" + idFranja + ", inicioFranja=" + inicioFranja + ", finFranja=" + finFranja
				+ ", ocupacionMaxima=" + ocupacionMaxima + "]";
	}
	

}
