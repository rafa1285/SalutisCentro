package es.salutiscentro.gestion.model;

import java.util.Date;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Clase Beans que contiene todos los datos en referente a un terapeuta.
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Entity
@Table(name = "terapeuta")
public class Terapeuta {

	// VARIABLES ===================================================================
	private Integer id_empleado;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fecha_nacimiento;
	private String direccion;
	private Integer telefono;
	private String email;
	private TipoUsuario tipoUsuario;
	private Especialidad especialidad_id;

	private Set<Paciente> pacientes;
	private Set<Cita> citas;

	// GETTERS/SETTERS =============================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

	@NotEmpty
	@Length(max = 9)
	@Column(name = "dni", nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@NotEmpty
	@Length(max = 45)
	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@NotEmpty
	@Length(max = 45)
	@Column(name = "apellido1", nullable = false, length = 45)
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Length(max = 45)
	@Column(name = "apellido2", nullable = true, length = 45)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@NotNull
	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@NotEmpty
	@Length(max = 100)
	@Column(name = "direccion", nullable = false, length = 100)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// @NotEmpty
	// @Length(max=11)
	// @Column(name = "telefono", nullable = false, length = 11)
	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Email
	@Length(max = 45)
	@Column(name = "email", nullable = true, length = 45)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name = "tipo_usuario_id")
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@ManyToOne
	@JoinColumn(name = "especialidad_id")
	public Especialidad getEspecialidad_id() {
		return especialidad_id;
	}

	public void setEspecialidad_id(Especialidad especialidad_id) {
		this.especialidad_id = especialidad_id;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "terapeuta_id")
	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "terapeuta_id")
	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

}
