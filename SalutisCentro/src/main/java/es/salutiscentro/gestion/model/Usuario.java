package es.salutiscentro.gestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario {

	private Integer id_usuario;
	private String username;
	private String password;
	private TipoUsuario tipo;
	private String claveRepetida;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	@NotEmpty
	@Column(name = "username", nullable = false, length = 15)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty
	@Column(name = "password", nullable = false, length = 15)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	@NotEmpty
	@Transient
	public String getClaveRepetida() {
		return claveRepetida;
	}

	public void setClaveRepetida(String claveRepetida) {
		this.claveRepetida = claveRepetida;
	}

}
