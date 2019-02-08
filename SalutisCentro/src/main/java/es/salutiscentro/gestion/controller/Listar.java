package es.salutiscentro.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.service.PacienteSvc;
import es.salutiscentro.gestion.service.TerapeutaSvc;

/**
 * Clase que se encarga de listar los datos de la aplicacion
 * 
 * @author Rafael Justo
 *
 */
// Indica que se trata de un controlador
@Controller
public class Listar {

	private static final String ATT_LISTA_PACIENTE = "listaPaciente";
	private static final String ATT_LISTA_TERAPEUTA = "listaTerapeuta";

	private static final String SUCCESS_TERAPEUTA = "terapeuta.list";
	private static final String SUCCESS_PACIENTE = "paciente.list";
	private static final String SUCCESS_DIAGNOSTICO = "diagnostico.list";
	private static final String SUCCESS_CITAS = "cita.list";

	private static final String ERROR = "error";
	private static final String ATT_ERROR = "error";

	private static final String ATT_ITEM_PACIENTE = "paciente";

	// Autoinyeccion del servicio
	@Autowired
	private PacienteSvc pacienteSvc;

	@Autowired
	private TerapeutaSvc terapeutaSvc;

	/**
	 * Metodo que se encarga de listar los pacientes de la BBDD
	 * 
	 * @param model
	 *            donde cargamos los atributos necesarios para listar los pacientes
	 * @return En caso de exito a una lista con todos los pacientes y en caso de
	 *         error a una pagina de error.
	 */
	@RequestMapping(value = "/listarPaciente", method = RequestMethod.GET)
	public String execute(Model model) {
		try {
			model.addAttribute(ATT_LISTA_PACIENTE, pacienteSvc.listar());
			return SUCCESS_PACIENTE;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo que se encarga de listar los terapeutas de la BBDD
	 * 
	 * @param model
	 *            donde cargamos los atributos necesarios para listar los terapeutas
	 * @return En caso de exito a una lista con todos los terapeutas y en caso de
	 *         error a una pagina de error.
	 */
	@RequestMapping(value = "/listarTerapeuta", method = RequestMethod.GET)
	public String executeT(Model model) {
		try {
			model.addAttribute(ATT_LISTA_TERAPEUTA, terapeutaSvc.listar());
			return SUCCESS_TERAPEUTA;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para listar las citas que tiene asignada un paciente.
	 * 
	 * @param id
	 *            parametro que identifica al paciente que buscamos sus citas
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirige a una lista con el historial de citas y
	 *         para asignarle nuevas citas
	 */
	@RequestMapping(value = "/listarCitasPaciente", method = RequestMethod.GET)
	public String executeCitasPaciente(@RequestParam int id, Model model) {
		try {
			Paciente p = pacienteSvc.buscar(id);
			model.addAttribute(ATT_ITEM_PACIENTE, pacienteSvc.buscar(id));
			model.addAttribute(ATT_LISTA_PACIENTE, p.getCitas());
			return SUCCESS_CITAS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para listar las citas que tiene asignada un terapeuta
	 * 
	 * @param id
	 *            parametro que identifica al terapeuta que buscamos sus citas
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirige a una lista con el historial de citas de un
	 *         terapeuta
	 */
	@RequestMapping(value = "/listarCitasTerapeuta", method = RequestMethod.GET)
	public String executeCitas(@RequestParam int id, Model model) {
		try {
			Terapeuta t = terapeutaSvc.buscar(id);
			model.addAttribute(ATT_LISTA_PACIENTE, t.getCitas());
			return SUCCESS_CITAS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para listar los diagnosticos de un Paciente
	 * 
	 * @param id
	 *            parametro que identifica al paciente asociado con el diagnostico
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirige a una lista con el historial de diagnostico
	 *         de un paciente
	 */
	@RequestMapping(value = "/listarDiagnosticoPaciente", method = RequestMethod.GET)
	public String executeDiagnosticoPaciente(@RequestParam int id, Model model) {
		try {
			Paciente p = pacienteSvc.buscar(id);
			model.addAttribute(ATT_ITEM_PACIENTE, pacienteSvc.buscar(id));
			model.addAttribute(ATT_LISTA_PACIENTE, p.getDiagnosticos());
			return SUCCESS_DIAGNOSTICO;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para buscar un terapeuta y filtra todos sus pacientes asignados
	 * 
	 * @param id
	 *            parametro que identifica al terapeuta que buscamos
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos a la lista de pacientes que tiene un
	 *         terapeuta, en caso de error a pagina de error
	 */
	@RequestMapping(value = "/listarPacientesTerapeuta", method = RequestMethod.GET)
	public String executeTerapeuta(@RequestParam int id, Model model) {
		try {
			Terapeuta t = terapeutaSvc.buscar(id);
			model.addAttribute(ATT_LISTA_PACIENTE, t.getPacientes());
			return SUCCESS_PACIENTE;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
