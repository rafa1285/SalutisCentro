package es.salutiscentro.gestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * Clase que contiene todas las especialidades que tienen los terapeutas dados
 * de alta
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Entity
@Table(name = "especialidad")
public class Especialidad {

	// VARIABLES ===================================================================
	private Integer id_especialidad;
	private String especialidad;

	// GETTERS/SETTERS =============================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Integer id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	@NotEmpty
	@Length(max = 45)
	@Column(name = "especialidad", nullable = false, length = 45)
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
