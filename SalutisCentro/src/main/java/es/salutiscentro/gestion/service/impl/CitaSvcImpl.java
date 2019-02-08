package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Cita;
import es.salutiscentro.gestion.model.dao.CitaDao;
import es.salutiscentro.gestion.service.CitaSvc;
import es.salutiscentro.gestion.service.SvcException;

/**
 * Clase Servicio encargada de pedir las operaciones a realizar a la clase Dao
 * correspondiente relacionadas con una Cita
 * 
 * @author Rafael Justo
 *
 */
@Service
@Transactional
public class CitaSvcImpl implements CitaSvc {

	@Autowired
	private CitaDao dao;

	/**
	 * Recibe una lista de citas pidiendoselo al dao citas
	 */
	@Override
	public Iterable<Cita> listar() throws SvcException {
		Iterable<Cita> cita = null;
		try {
			cita = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return cita;
	}

	/**
	 * Se encarga de pedirle al dao que guarde una cita
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Cita cita) throws SvcException {
		try {
			dao.save(cita);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
	}

	/**
	 * Se encarga de pedirle al dao que modifique una lista
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Cita cita) throws SvcException {
		try {
			dao.update(cita);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
	}

	/**
	 * Se encarga de pedirle al dao que busque una cita
	 */
	@Override
	public Cita buscar(int id) throws SvcException {
		Cita cita = null;
		try {
			cita = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return cita;
	}

}
