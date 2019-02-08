package es.salutiscentro.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import es.salutiscentro.gestion.model.Cita;
import es.salutiscentro.gestion.model.Diagnostico;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.service.EspecialidadSvc;
import es.salutiscentro.gestion.service.PacienteSvc;
import es.salutiscentro.gestion.service.TerapeutaSvc;
import es.salutiscentro.gestion.service.TipoUsuarioSvc;

/**
 * Clase que se encarga de crear nuevos datos para la aplicacion
 * 
 * @author Rafael Justo
 *
 */
@Controller
public class Nuevo {

	// ATRIBUTOS
	private static final String ATT_LISTA_ESPECIALIDAD = "listaEspecialidad";
	private static final String ATT_LISTA_TERAPEUTAS = "listaTerapeuta";
	private static final String ATT_LISTA_TIPOUSUARIO = "listaTipoUsuario";

	private static final String ATT_ITEM_PACIENTE = "paciente";

	// REDIRECCIONES A PAGINAS. CON LAS TILES LE PONEMOS EL NOMBRE QUE ESTA ASOCIADO
	// A LA RUTA CORRESPONDIENTE
	private static final String SUCCESS_PACIENTE = "paciente.form";
	private static final String SUCCESS_TERAPEUTA = "terapeuta.form";
	private static final String SUCCESS_CITA_NUEVA = "cita.form";
	private static final String SUCCESS_DIAGNOSTICO = "diagnostico.form";

	private static final String ERROR_PACIENTE = "paciente.form";
	private static final String ERROR_TERAPEUTA = "terapeuta.form";
	private static final String ERROR = "error";
	private static final String ATT_ERROR = "exception";

	@Autowired
	private PacienteSvc pacienteSvc;

	@Autowired
	private TerapeutaSvc terapeutaSvc;

	@Autowired
	private EspecialidadSvc especialidadSvc;

	@Autowired
	private TipoUsuarioSvc tipoUsuarioSvc;

	/**
	 * Metodo que carga en el modelo un atributo con la lista de terapeutas y en
	 * caso satisfactorio redirige al formulario para dar de alta un nuevo paciente
	 * 
	 * @param paciente
	 *            Objeto paciente con los datos personales
	 * @param model
	 *            cargamos los atributos de terapeuta o de error en caso de error
	 * @return redirige al formulario o en caso de error recarga el mismo formulario
	 */
	@RequestMapping(value = "/nuevoPaciente", method = RequestMethod.GET)
	public String view(@ModelAttribute Paciente paciente, Model model) {
		try {
			// Incluir elementos para la seleccion
			model.addAttribute(ATT_LISTA_TERAPEUTAS, terapeutaSvc.listar());
			return SUCCESS_PACIENTE;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR_PACIENTE;
		}
	}

	/**
	 * Metodo que carga en el modelo un atributo con la lista de especialidades y
	 * tipos de usuario y en caso satisfactorio redirige al formulario para dar de
	 * alta un nuevo terapeuta
	 * 
	 * @param terapeuta
	 *            Objeto terapeuta con los datos personales
	 * @param model
	 *            cargamos atributos necesarios para listar un terapeuta
	 * @return redirige al formulario o en caso de error regarga el mismo formulario
	 */
	@RequestMapping(value = "/nuevoTerapeuta", method = RequestMethod.GET)
	public String viewT(@ModelAttribute Terapeuta terapeuta, Model model) {
		try {
			// Incluir elementos para la seleccion
			model.addAttribute(ATT_LISTA_ESPECIALIDAD, especialidadSvc.listar());
			model.addAttribute(ATT_LISTA_TIPOUSUARIO, tipoUsuarioSvc.listar());
			return SUCCESS_TERAPEUTA;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR_TERAPEUTA;
		}
	}

	/**
	 * Metodo que busca un paciente para darle una cita nueva
	 * 
	 * @param id
	 *            parametro que identifica al paciente que buscamos
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos al formulario con los datos cargados del
	 *         paciente para pedir una cita nueva, en caso de error a una pagina de
	 *         error
	 */
	@RequestMapping(value = "/CitaNueva", method = RequestMethod.GET)
	public String executeCitasNueva(@ModelAttribute Cita cita, @RequestParam int id, Model model) {
		try {
			model.addAttribute(ATT_ITEM_PACIENTE, pacienteSvc.buscar(id));
			model.addAttribute(ATT_LISTA_TERAPEUTAS, terapeutaSvc.listar());
			return SUCCESS_CITA_NUEVA;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo que busca un paciente para asignarle un diagnostico nuevo
	 * 
	 * @param diagnostico
	 *            cargamos el objeto en el modelo attribute para despues recuperar
	 *            datos de el
	 * @param id
	 *            identificador del paciente asociado al diagnostico
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso de exito redirigimos al formulario con los datos cargados del
	 *         paciente para asignar un diagnostico nuevo, en caso de error a una
	 *         pagina de error
	 */
	@RequestMapping(value = "/DiagnosticoNuevo", method = RequestMethod.GET)
	public String executeDiagnostico(@ModelAttribute Diagnostico diagnostico, @RequestParam int id, Model model) {
		try {
			model.addAttribute(ATT_ITEM_PACIENTE, pacienteSvc.buscar(id));
			model.addAttribute(ATT_LISTA_TERAPEUTAS, terapeutaSvc.listar());
			return SUCCESS_DIAGNOSTICO;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
