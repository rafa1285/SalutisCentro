package es.salutiscentro.gestion.service.impl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Diagnostico;
import es.salutiscentro.gestion.model.dao.DiagnosticoDao;
import es.salutiscentro.gestion.service.DiagnosticoSvc;
import es.salutiscentro.gestion.service.SvcException;

/**
 * Clase Servicio encargada de pedir las operaciones a realizar a la clase Dao
 * correspondiente relacionadas con un Diagnostico
 * 
 * @author Rafael Justo
 *
 */
@Service
@Transactional
public class DiagnosticoSvcImpl implements DiagnosticoSvc {

	@Autowired
	private DiagnosticoDao dao;

	/**
	 * Recibe una lista de diagnosticos pidiendoselo al dao diagnostico
	 */
	@Override
	public Iterable<Diagnostico> listar() throws SvcException {
		Iterable<Diagnostico> diag = null;
		try {
			diag = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return diag;
	}

	/**
	 * Se encarga de pedirle al dao que busque un diagnostico
	 */
	@Override
	public Diagnostico buscar(int id) throws SvcException {
		Diagnostico diagnostico = null;
		try {
			diagnostico = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return diagnostico;
	}

	/**
	 * Se encarga de pedirle al dao que guarde un diagnostico
	 */
	@Override
	public void guardar(@Valid Diagnostico diagnostico) throws SvcException {
		try {
			dao.save(diagnostico);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
	}

	/**
	 * Se encarga de pedirle al dao que modifique un diagnostico
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(@Valid Diagnostico diagnostico) throws SvcException {
		try {
			dao.update(diagnostico);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

	}

}
