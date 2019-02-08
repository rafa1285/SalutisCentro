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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Clase Beans que contiene todos los datos en referente a un paciente.
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Entity
@Table(name = "paciente")
public class Paciente {

	// VARIABLES ===================================================================
	private Integer id_paciente;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fecha_nacimiento;
	private String direccion;
	private Integer telefono;
	private String email;
	private String historial;
	private String motivo_consulta;
	private Terapeuta terapeuta_id;

	private Set<Cita> citas;
	private Set<Diagnostico> diagnosticos;

	// GETTERS/SETTERS =============================================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
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

	@Length(max = 300)
	@Column(name = "historial", nullable = true, length = 300)
	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	@NotEmpty
	@Length(max = 100)
	@Column(name = "motivo_consulta", nullable = false, length = 100)
	public String getMotivo_consulta() {
		return motivo_consulta;
	}

	public void setMotivo_consulta(String motivo_consulta) {
		this.motivo_consulta = motivo_consulta;
	}

	@ManyToOne
	@JoinColumn(name = "terapeuta_id")
	public Terapeuta getTerapeuta_id() {
		return terapeuta_id;
	}

	public void setTerapeuta_id(Terapeuta terapeuta_id) {
		this.terapeuta_id = terapeuta_id;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "paciente_id")
	@OrderBy("fecha_cita ASC")
	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "paciente_id")
	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

}
