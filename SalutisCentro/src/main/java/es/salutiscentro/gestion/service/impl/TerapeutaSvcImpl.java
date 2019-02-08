package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.model.dao.TerapeutaDao;
import es.salutiscentro.gestion.service.SvcException;
import es.salutiscentro.gestion.service.TerapeutaSvc;

/**
 * Clase Servicio encargada de pedir las operaciones a realizar a la clase Dao
 * correspondiente relacionadas con un Terapeuta
 * 
 * @author Rafael Justo
 *
 */
@Service
@Transactional
public class TerapeutaSvcImpl implements TerapeutaSvc {

	@Autowired
	private TerapeutaDao dao;

	/**
	 * Recibe una lista de terapeutas pidiendoselo al dao terapeuta
	 */
	@Override
	public Iterable<Terapeuta> listar() throws SvcException {
		Iterable<Terapeuta> tera = null;
		try {
			tera = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return tera;
	}

	/**
	 * Se encarga de pedirle al dao que busque un terapeuta
	 */
	@Override
	public Terapeuta buscar(int id) throws SvcException {
		Terapeuta tera = null;
		try {
			tera = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return tera;
	}

	/**
	 * Se encarga de pedirle al dao que guarde un terapeuta
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Terapeuta terapeuta) throws SvcException {
		try {
			dao.save(terapeuta);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}		
	}

	/**
	 * Se encarga de pedirle al dao que modifique un terapeuta
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Terapeuta terapeuta) throws SvcException {
		try {
			dao.update(terapeuta);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}		
	}

	/**
	 * Se encarga de pedirle al dao que borre un terapeuta
	 */
	@Override
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void eliminar(Terapeuta tera) throws SvcException {
		try{
			tera = buscar(tera.getId_empleado());
			dao.delete(tera);
		}catch (Exception ex){
			throw new SvcException(ex);
		}			
	}
}
