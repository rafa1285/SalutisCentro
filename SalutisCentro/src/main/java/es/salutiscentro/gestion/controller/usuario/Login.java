package es.salutiscentro.gestion.controller.usuario;

import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import es.salutiscentro.gestion.interceptor.LoginInterceptor;
import es.salutiscentro.gestion.model.TipoUsuario;
import es.salutiscentro.gestion.model.Usuario;
import es.salutiscentro.gestion.service.SvcException;
import es.salutiscentro.gestion.service.UsuarioSvc;

/**
 * Clase encargada de hacer el login del usuario, validarlo y cargarlo en la
 * sesion. Tambien realiza el cierre de la sesion
 * 
 * @author Rafael Justo
 *
 */
@Controller
@SessionAttributes({ "sessionUser" })
@RequestMapping(value = "/usuario")
public class Login {

	private static final String MSG_ERROR = "usuario.login.error";
	private static final String MSG_ERROR_USER = "usuario.registro.error";
	private static final String MSG_ERROR_GRAL = "error.general";

	private static final Log log = LogFactory.getLog(Login.class);

	private static final String LOGIN = "login.form";
	private static final String FORM = "usuario.form";
	private static final String ERROR = "login.form";
	private static final String SUCCESS = "redirect:/inicio";
	private static final String INICIO = "redirect:/usuario/login";

	@Autowired
	private UsuarioSvc UsuarioSvc;

	/**
	 * Metodo que carga el formulario de login al inicio de la aplicacion a traves
	 * de un GET
	 * 
	 * @param usuario
	 *            Objeto cargado en el Model Attribute
	 * @param model
	 * @return retorna a la pagina de inicio de sesion
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String view(@ModelAttribute Usuario usuario, Model model) {
		return LOGIN;
	}

	/**
	 * Metodo encargado de iniciar sesion y de validar al usuario
	 * 
	 * @param usuario
	 *            Objeto usuario con los datos de user y pass
	 * @param result
	 *            se encarga de recoger los errores
	 * @param model
	 *            cargamos los atributos para su posterior uso
	 * @return En caso satisfactorio redirige al inicio de la aplicacion, en caso de
	 *         error recarga la pagina y muestra el mensaje de error
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String execute(@Valid Usuario usuario, BindingResult result, Model model) {
		try {
			// No tiene en cuenta validación del resto de campos (registro)
			if (result.getFieldError("username") != null || result.getFieldError("password") != null) {
				return LOGIN;
			} else {
				usuario = UsuarioSvc.identificar(usuario);
				if (usuario == null) {
					// Asignamos el error al id para filtrado en formulario
					result.rejectValue("id_usuario", MSG_ERROR);
					return LOGIN;
				} else {
					inicializar(usuario, model);
					return SUCCESS;
				}
			}
		} catch (Exception ex) {
			log.error(ex);
			// Asignamos el error al id para filtrado en formulario
			result.rejectValue("id_usuario", MSG_ERROR);
			return ERROR;
		}
	}

	/**
	 * Inicializar la sesión y se lo manda al interceptor
	 * 
	 * @param usuario
	 *            objeto mandado a la sesion
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 */
	private void inicializar(Usuario usuario, Model model) {
		// Agregar el usuario a la sesión para el interceptor
		model.addAttribute(LoginInterceptor.ATT_USER, usuario);
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.GET)
	public String reg(@ModelAttribute Usuario usuario, Model model) {
		return FORM;
	}

	/**
	 * Metodo encargado de registrar a un usuario
	 * 
	 * @param usuario
	 *            objeto usuario a crear
	 * @param result
	 *            comprueba los errores
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @return En caso satisfactorio redirige a la pagina de inicio, en caso
	 *         contrario recarga la pagina
	 */
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registro(@Valid Usuario usuario, BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				return FORM;
			} else {
				// Establecer el tipo por defecto
				TipoUsuario tipo = new TipoUsuario();
				tipo.setId_tipo(2);
				usuario.setTipo(tipo);
				UsuarioSvc.guardar(usuario);
				inicializar(usuario, model);
				return SUCCESS;
			}
		} catch (SvcException ex) {
			log.error(ex);
			// Comprobar si la causa es por usuario duplicado
			if (ex.getCause() instanceof DataIntegrityViolationException) {
				result.rejectValue("id_usuario", MSG_ERROR_USER);
			} else {
				result.rejectValue("id_usuario", MSG_ERROR_GRAL);
			}
			return FORM;
		} catch (Exception ex) {
			log.error(ex);
			result.rejectValue("id", MSG_ERROR_GRAL);
			return FORM;
		}
	}

	/**
	 * Metodo que se encarga de cerrar la sesion de un usuario
	 * 
	 * @param model
	 *            cargamos los atributos necesarios para su posterior uso
	 * @param sessionStatus
	 *            marcamos el estado de la sesion
	 * @return Redirige a la pagina de inicio de sesion
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus) {
		// Destrucción de la sesión
		sessionStatus.setComplete();
		// Hace un redirect, para completar el cierre de sesión
		return INICIO;
	}

}
