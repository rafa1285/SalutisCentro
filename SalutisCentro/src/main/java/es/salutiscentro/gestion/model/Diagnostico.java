package es.salutiscentro.gestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * Clase que contiene el diagnostico de un paciente
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Entity
@Table(name = "diagnostico")
public class Diagnostico {

	// VARIABLES ===================================================================
	private Integer id_diagnostico;
	private String diagnostico;
	private Paciente paciente_id;

	// GETTERS/SETTERS =============================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_diagnostico() {
		return id_diagnostico;
	}

	public void setId_diagnostico(Integer id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}

	@Length(max = 100)
	@Column(name = "diagnostico", nullable = true, length = 100)
	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	public Paciente getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(Paciente paciente_id) {
		this.paciente_id = paciente_id;
	}

}
