package es.salutiscentro.gestion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.salutiscentro.gestion.model.Cita;
import es.salutiscentro.gestion.model.Diagnostico;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.service.CitaSvc;
import es.salutiscentro.gestion.service.DiagnosticoSvc;
import es.salutiscentro.gestion.service.EspecialidadSvc;
import es.salutiscentro.gestion.service.PacienteSvc;
import es.salutiscentro.gestion.service.TerapeutaSvc;
import es.salutiscentro.gestion.service.TipoUsuarioSvc;

/**
 * Clase que se encarga de guardar los datos de la aplicacion
 * 
 * @author Rafael Justo
 *
 */
@Controller
public class Guardar {

	private static final String ATT_LISTA_TERAPEUTA = "listaTerapeuta";
	private static final String ATT_LISTA_TIPOUSUARIO = "listaTipoUsuario";
	private static final String ATT_LISTA_ESPECIALIDAD = "listaEspecialidad";
	private static final String ATT_LISTA_PACIENTE = "listaPaciente";

	private static final String ATT_EXITO = "msg";

	private static final String SUCCESS_PACIENTE = "paciente.form";
	private static final String SUCCESS_TERAPEUTA = "terapeuta.form";
	private static final String SUCCESS_CITA = "cita.form";
	private static final String SUCCESS_DIAGNOSTICO = "diagnostico.form";

	private static final String ERROR_PACIENTE = "paciente.form";
	private static final String ERROR_TERAPEUTA = "terapeuta.form";
	private static final String ERROR_CITA = "cita.form";
	private static final String ERROR_DIAGNOSTICO = "diagnostico.form";

	private static final String ATT_ITEM_PACIENTE = "paciente";
	private static final String ATT_ITEM_TERAPEUTA = "terapeuta";
	private static final String ATT_ITEM_CITA = "cita";
	private static final String ATT_ITEM_DIAGNOSTICO = "diagnostico";

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

	@Autowired
	private MessageSource messageSource;

	/**
	 * Se encarga de parsear las fechas correctamente cuando vienen de formulario
	 * 
	 * @param binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/**
	 * Se encargar de guardar los datos de un paciente
	 * 
	 * @param paciente
	 *            Objeto con los datos del paciente
	 * @param result
	 *            Para comprobar errores
	 * @param model
	 *            Donde cargamos los atributos para su posterior uso
	 * @param locale
	 *            Indica el idoma de los mensajes
	 * @return Redirige a formulario en caso de exito o recarga formulario en caso
	 *         de error
	 */
	@RequestMapping(value = "/guardarPaciente", method = RequestMethod.POST)
	public String execute(@Valid Paciente paciente, BindingResult result, Model model, Locale locale) {
		try {
			model.addAttribute(ATT_LISTA_TERAPEUTA, terapeutaSvc.listar());
			// Comprobar si hay errores de entrada
			if (result.hasErrors()) {
				return ERROR_PACIENTE;
			} else {
				// Si no hay errores, Guardar comprobando si hay id_paciente para saber si
				// editamos o guardamos
				if (paciente.getId_paciente() == null) {
					pacienteSvc.guardar(paciente);
				} else {
					pacienteSvc.modificar(paciente);
				}
				// Mensaje de exito
				model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
				// Limpiar formulario
				model.addAttribute(ATT_ITEM_PACIENTE, new Paciente());
				return SUCCESS_PACIENTE;
			}
		} catch (Exception ex) {
			// Error
			result.reject("mensaje.error");
			return ERROR_PACIENTE;
		}
	}

	/**
	 * Se encarga de guardar los datos de un Terapeuta
	 * 
	 * @param terapeuta
	 *            Objeto con los datos del terapeuta
	 * @param result
	 *            Para comprobar errores
	 * @param model
	 *            Donde cargamos los atributos para su posterior uso
	 * @param locale
	 *            Indica el idoma de los mensajes
	 * @return Redirige a formulario en caso de exito o recarga formulario en caso
	 *         de error
	 */
	@RequestMapping(value = "/guardarTerapeuta", method = RequestMethod.POST)
	public String executeTerapeuta(@Valid Terapeuta terapeuta, BindingResult result, Model model, Locale locale) {
		try {
			model.addAttribute(ATT_LISTA_ESPECIALIDAD, especialidadSvc.listar());
			model.addAttribute(ATT_LISTA_TIPOUSUARIO, tipoUsuarioSvc.listar());
			if (result.hasErrors()) {
				return ERROR_TERAPEUTA;
			} else {
				if (terapeuta.getId_empleado() == null) {
					terapeutaSvc.guardar(terapeuta);
				} else {
					terapeutaSvc.modificar(terapeuta);
				}
				model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
				model.addAttribute(ATT_ITEM_TERAPEUTA, new Terapeuta());
				return SUCCESS_TERAPEUTA;
			}
		} catch (Exception ex) {
			result.reject("mensaje.error");
			return ERROR_TERAPEUTA;
		}
	}

	/**
	 * Se encarga de guardar los datos de una Cita
	 * 
	 * @param cita
	 *            Objeto con los datos de la cita
	 * @param result
	 *            Para comprobar errores
	 * @param model
	 *            Donde cargamos los atributos para su posterior uso
	 * @param locale
	 *            Indica el idoma de los mensajes
	 * @return Redirige a formulario en caso de exito o recarga formulario en caso
	 *         de error
	 */
	@RequestMapping(value = "/guardarCita", method = RequestMethod.POST)
	public String executeCita(@Valid Cita cita, BindingResult result, Model model, Locale locale) {
		try {
			model.addAttribute(ATT_LISTA_TERAPEUTA, terapeutaSvc.listar());
			model.addAttribute(ATT_LISTA_PACIENTE, pacienteSvc.listar());
			if (result.hasErrors()) {
				return ERROR_CITA;
			} else {
				if (cita.getId_cita() == null) {
					citaSvc.guardar(cita);
				} else {
					citaSvc.modificar(cita);
				}
				model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
				model.addAttribute(ATT_ITEM_CITA, new Cita());
				return SUCCESS_CITA;
			}
		} catch (Exception ex) {
			result.reject("mensaje.error");
			return ERROR_CITA;
		}
	}

	/**
	 * Se encarga de guardar los datos de un Diagnostico
	 * 
	 * @param diagnostico
	 *            Objeto con los datos del diagnostico
	 * @param result
	 *            Para comprobar errores
	 * @param model
	 *            Donde cargamos los atributos para su posterior uso
	 * @param locale
	 *            Indica el idoma de los mensajes
	 * @return Redirige a formulario en caso de exito o recarga formulario en caso
	 *         de error
	 */
	@RequestMapping(value = "/guardarDiagnostico", method = RequestMethod.POST)
	public String executeDiagnostico(@Valid Diagnostico diagnostico, BindingResult result, Model model, Locale locale) {
		try {
			model.addAttribute(ATT_LISTA_PACIENTE, pacienteSvc.listar());
			if (result.hasErrors()) {
				return ERROR_DIAGNOSTICO;
			} else {
				if (diagnostico.getId_diagnostico() == null) {
					diagnosticoSvc.guardar(diagnostico);
				} else {
					diagnosticoSvc.modificar(diagnostico);
				}
				model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
				model.addAttribute(ATT_ITEM_DIAGNOSTICO, new Diagnostico());
				return SUCCESS_DIAGNOSTICO;
			}
		} catch (Exception ex) {
			result.reject("mensaje.error");
			return ERROR_DIAGNOSTICO;
		}
	}

}
