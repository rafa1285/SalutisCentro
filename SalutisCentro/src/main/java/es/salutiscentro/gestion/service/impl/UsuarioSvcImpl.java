package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Usuario;
import es.salutiscentro.gestion.model.dao.UsuarioDao;
import es.salutiscentro.gestion.service.SvcException;
import es.salutiscentro.gestion.service.UsuarioSvc;

/**
 * Clase Servicio encargada de pedir las operaciones a realizar a la clase Dao
 * correspondiente relacionadas con un Usuario
 * 
 * @author Rafael Justo
 *
 */
@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc {

	private static final String URI_INICIO = "inicio";
	private static final String URI_USUARIO = "usuario/login";
	private static final String URI_USUARIO_LOGOUT = "usuario/logout";
	private static final String URI_PACIENTE = "buscarPaciente";
	private static final String URI_CITA = "buscarCita";
	private static final String URI_DIAGNOSTICO = "buscarDiagnostico";
	private static final String URI_GUARDAR_DIAGNOSTICO = "guardarDiagnostico";
	private static final String URI_LISTAR_PACIENTE = "listarPaciente";
	private static final String URI_LISTAR_CITAS_PACIENTE = "listarCitasPaciente";
	private static final String URI_LISTAR_CITAS_TERAPEUTA = "listarCitasTerapeuta";
	private static final String URI_LISTAR_DIAGNOSTICO = "listarDiagnosticoPaciente";
	private static final String URI_NUEVA_CITA = "CitaNueva";
	private static final String URI_NUEVO_DIAGNOSTICO = "DiagnosticoNuevo";

	@Autowired
	private UsuarioDao dao;

	/**
	 * Recibe un usuario identificado pidiendoselo al dao usuario
	 */
	@Override
	public Usuario identificar(Usuario usuario) throws SvcException {
		Usuario res = null;
		try {
			res = dao.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return res;
	}

	/**
	 * Metodo que comprueba el tipo de usuario para restringir o dar acceso a
	 * ciertos recursos
	 */
	@Override
	public boolean comprobar(Usuario usuario, String uri) throws SvcException {
		switch (usuario.getTipo().getId_tipo()) {
		case 1:
			return true;
		case 2:
			// url a las cuales tiene acceso
			 return (uri.contains(URI_INICIO) ||
			 uri.contains(URI_USUARIO) ||
			 uri.contains(URI_PACIENTE) ||
			 uri.contains(URI_CITA) ||
			 uri.contains(URI_DIAGNOSTICO) ||
			 uri.contains(URI_GUARDAR_DIAGNOSTICO) ||
			 uri.contains(URI_LISTAR_PACIENTE) ||
			 uri.contains(URI_LISTAR_CITAS_PACIENTE) ||
			 uri.contains(URI_LISTAR_CITAS_TERAPEUTA) ||
			 uri.contains(URI_LISTAR_DIAGNOSTICO) ||
			 uri.contains(URI_NUEVA_CITA) ||
			 uri.contains(URI_USUARIO_LOGOUT) ||
			 uri.contains(URI_NUEVO_DIAGNOSTICO));
		default:
			return false;
		}
	}

	/**
	 * Metodo que se encarga de pedir al dao que guarde un usuario
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Usuario item) throws SvcException {
		try {
			dao.save(item);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
	}

}
