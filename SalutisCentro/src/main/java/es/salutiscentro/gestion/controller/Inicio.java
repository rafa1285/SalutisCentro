package es.salutiscentro.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para el cambio de idioma, simplemente redirige a página de inicio
 * 
 * @author Rafael Justo
 *
 */
@Controller
public class Inicio {

	private static final String SUCCESS = "inicio.form";

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String execute(Model model) {
		return SUCCESS;
	}

}
