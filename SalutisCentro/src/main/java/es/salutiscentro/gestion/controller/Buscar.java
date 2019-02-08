package es.salutiscentro.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import es.salutiscentro.gestion.service.CitaSvc;
import es.salutiscentro.gestion.service.DiagnosticoSvc;
import es.salutiscentro.gestion.service.EspecialidadSvc;
import es.salutiscentro.gestion.service.PacienteSvc;
import es.salutiscentro.gestion.service.TerapeutaSvc;
import es.salutiscentro.gestion.service.TipoUsuarioSvc;

/**
 * Clase encargada de buscar datos de la aplicacion para modificarlas.
 * 
 * @author Rafael Justo
 *
 */
@Controller
public class Buscar {

	private static final String ATT_ITEM_PACIENTE = "paciente";
	private static final String ATT_ITEM_TERAPEUTA = "terapeuta";
	private static final String ATT_ITEM_DIAGNOSTICO = "diagnostico";
	private static final String ATT_ITEM_CITA = "cita";

	private static final String ATT_LISTA_TERAPEUTA = "listaTerapeuta";
	private static final String ATT_LISTA_PACIENTE = "listaPaciente";
	private static final String ATT_LISTA_ESPECIALIDAD = "listaEspecialidad";
	private static final String ATT_LISTA_TIPO_USUARIO = "listaTipoUsuario";

	private static final String SUCCESS_PACIENTE = "paciente.form";
	private static final String SUCCESS_CITA = "cita.form";
	private static final String SUCCESS_TERAPEUTA = "terapeuta.form";
	private static final String SUCCESS_DIAGNOSTICO = "diagnostico.form";

	private static final String ERROR = "error";
	private static final String ATT_ERROR = "error";

	@Autowired
	private PacienteSvc pacienteSvc;

	@Autowired
	private TerapeutaSvc terapeutaSvc;

	@Autowired
	private EspecialidadSvc especialidadSvc;

	@Autowired
	private TipoUsuarioSvc tipoUsuarioSvc;

	@Autowired
	private CitaSvc citaSvc;

	@Autowired
	private DiagnosticoSvc diagnosticoSvc;

	/**
	 * Busca un paciente para ser editado
	 * 
	 * @param id
	 *            parametro que identifica al paciente que vamos a editar
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos al formulario con los datos cargados del
	 *         paciente a editar, en caso de error a una pagina de error
	 */
	@RequestMapping(value = "/buscarPaciente", method = RequestMethod.GET)
	public String executePaciente(@RequestParam int id, Model model) {
		try {
			model.addAttribute(ATT_ITEM_PACIENTE, pacienteSvc.buscar(id));
			model.addAttribute(ATT_LISTA_TERAPEUTA, terapeutaSvc.listar());
			return SUCCESS_PACIENTE;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para buscar un terapeuta y editarlo
	 * 
	 * @param id
	 *            parametro que identifica al terapeuta que buscamos
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos al formulario con los datos cargados del
	 *         terapeuta a editar, en caso de error a una pagina de error
	 */
	@RequestMapping(value = "/buscarTerapeutaEditar", method = RequestMethod.GET)
	public String executeT(@RequestParam int id, Model model) {
		try {
			model.addAttribute(ATT_ITEM_TERAPEUTA, terapeutaSvc.buscar(id));
			model.addAttribute(ATT_LISTA_ESPECIALIDAD, especialidadSvc.listar());
			model.addAttribute(ATT_LISTA_TIPO_USUARIO, tipoUsuarioSvc.listar());
			return SUCCESS_TERAPEUTA;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para buscar una cita y editarla
	 * 
	 * @param id
	 *            parametro que identifica la cita que buscamos
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos al formulario con los datos cargados de
	 *         la cita a editar, en caso de error a una pagina de error
	 */
	@RequestMapping(value = "/buscarCita", method = RequestMethod.GET)
	public String executeEditarCita(@RequestParam int id, Model model) {
		try {
			model.addAttribute(ATT_ITEM_CITA, citaSvc.buscar(id));
			model.addAttribute(ATT_LISTA_TERAPEUTA, terapeutaSvc.listar());
			return SUCCESS_CITA;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo para buscar un diagnostico y editarlo
	 * 
	 * @param id
	 *            parametro que identifica el diagnostico que buscamos
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos al formulario con los datos cargados del
	 *         diagnostico a editar, en caso de error a una pagina de error
	 */
	@RequestMapping(value = "/buscarDiagnostico", method = RequestMethod.GET)
	public String executeEditarHistorial(@RequestParam int id, Model model) {
		try {
			model.addAttribute(ATT_ITEM_DIAGNOSTICO, diagnosticoSvc.buscar(id));
			model.addAttribute(ATT_LISTA_PACIENTE, terapeutaSvc.listar());
			return SUCCESS_DIAGNOSTICO;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
