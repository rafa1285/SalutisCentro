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
 * Clase encargada de borrar datos de la aplicacion
 * 
 * @author Rafael Justo Sanchez
 *
 */

@Controller
public class Borrar {

	private static final String SUCCESS_TERAPEUTA = "forward:/listarTerapeuta";
	private static final String SUCCESS_PACIENTE = "forward:/listarPaciente";
	
	private static final String ERROR = "error";
	private static final String ATT_ERROR = "error";

	@Autowired
	private PacienteSvc pacienteSvc;

	@Autowired
	private TerapeutaSvc terapeutaSvc;

	/**
	 * Metodo que se encarga de borrar pacientes
	 * 
	 * @param id
	 *            parametro recogido que identifica al paciente a borrar
	 * @param model
	 *            cargamos atributos necesarios
	 * @return en caso de de exito redirige al listado de pacientes sin el paciente
	 *         borrado, en caso de error a una pagina de error
	 */
	@RequestMapping(value = "/borrarPaciente", method = RequestMethod.GET)
	public String borrar(@RequestParam int id, Model model) {
		try {
			Paciente paci = new Paciente();
			paci.setId_paciente(id);
			pacienteSvc.eliminar(paci);
			return SUCCESS_PACIENTE;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Metodo que se encargar de borrar terapeutas
	 * 
	 * @param id
	 *            id parametro recogido que identifica al terapeuta a borrar
	 * @param model
	 *            cargamos atributos necesarios
	 * @return en caso de de exito redirige al listado de terapeutas sin el
	 *         terapeuta borrado, en caso de error a una pagina de error
	 */
	@RequestMapping(value = "/borrarTerapeuta", method = RequestMethod.GET)
	public String borrarT(@RequestParam int id, Model model) {
		try {
			Terapeuta tera = new Terapeuta();
			tera.setId_empleado(id);
			terapeutaSvc.eliminar(tera);
			return SUCCESS_TERAPEUTA;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
