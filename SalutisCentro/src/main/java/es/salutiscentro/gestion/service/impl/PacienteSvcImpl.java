package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.PacienteDao;
import es.salutiscentro.gestion.service.PacienteSvc;
import es.salutiscentro.gestion.service.SvcException;

/**
 * Clase Servicio encargada de pedir las operaciones a realizar a la clase Dao
 * correspondiente relacionadas con un Paciente
 * 
 * @author Rafael Justo
 *
 */
@Service
@Transactional
public class PacienteSvcImpl implements PacienteSvc {

	@Autowired
	private PacienteDao dao;

	/**
	 * Se encarga de pedirle al dao que guarde un paciente
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Paciente paciente) throws SvcException {
		try {
			dao.save(paciente);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
	}

	/**
	 * Se encarga de pedirle al dao que modifique un paciente
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Paciente paciente) throws SvcException {
		try {
			dao.update(paciente);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
	}

	/**
	 * Recibe una lista de pacientes pidiendoselo al dao paciente
	 */
	@Override
	public Iterable<Paciente> listar() throws SvcException {
		Iterable<Paciente> paci = null;
		try {
			paci = dao.findByNombre("");
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return paci;
	}

	/**
	 * Se encarga de pedirle al dao que busque una paciente
	 */
	@Override
	public Paciente buscar(int id) throws SvcException {
		Paciente paci = null;
		try {
			paci = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return paci;
	}

	/**
	 * Se encarga de pedirle al dao que borre un paciente
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void eliminar(Paciente paci) throws SvcException {
		try {
			paci = buscar(paci.getId_paciente());
			dao.delete(paci);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

	}

}
