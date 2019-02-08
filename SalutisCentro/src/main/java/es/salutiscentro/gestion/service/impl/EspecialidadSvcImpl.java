package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Especialidad;
import es.salutiscentro.gestion.model.dao.EspecialidadDao;
import es.salutiscentro.gestion.service.EspecialidadSvc;
import es.salutiscentro.gestion.service.SvcException;

/**
 * Clase Servicio encargada de pedir las operaciones a realizar a la clase Dao
 * correspondiente relacionadas con una Especialidad
 * 
 * @author Rafael Justo
 *
 */
@Service
@Transactional
public class EspecialidadSvcImpl implements EspecialidadSvc {

	@Autowired
	private EspecialidadDao dao;

	/**
	 * Recibe una lista de especialidades pidiendoselo al dao Especialidad
	 */
	@Override
	public Iterable<Especialidad> listar() throws SvcException {
		Iterable<Especialidad> esp = null;
		try {
			esp = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return esp;
	}

}
