package es.salutiscentro.gestion.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Clase que contiene todos los datos referente a una cita dada a un usuario
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Entity
@Table(name = "cita")
public class Cita {

	// VARIABLES ===================================================================
	private Integer id_cita;
	private Date fecha_cita;
	private Paciente paciente_id;
	private Terapeuta terapeuta_id;

	// GETTERS/SETTERS =============================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_cita() {
		return id_cita;
	}

	public void setId_cita(Integer id_cita) {
		this.id_cita = id_cita;
	}

	@NotNull
	@Column(name = "fecha_cita", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getFecha_cita() {
		return fecha_cita;
	}

	public void setFecha_cita(Date fecha_cita) {
		this.fecha_cita = fecha_cita;
	}

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	public Paciente getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(Paciente paciente_id) {
		this.paciente_id = paciente_id;
	}

	@ManyToOne
	@JoinColumn(name = "terapeuta_id")
	public Terapeuta getTerapeuta_id() {
		return terapeuta_id;
	}

	public void setTerapeuta_id(Terapeuta terapeuta_id) {
		this.terapeuta_id = terapeuta_id;
	}

}
