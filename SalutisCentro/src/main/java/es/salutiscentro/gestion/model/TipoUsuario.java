package es.salutiscentro.gestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

/**
 * Clase que va indicar el Rol asignado a un terapeuta
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

	// VARIABLES ===================================================================
	private Integer id_tipo;
	private String tipo;

	// GETTERS/SETTERS =============================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	@Length(max = 20)
	@Column(name = "tipo", nullable = true, length = 20)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
