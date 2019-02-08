package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import javax.validation.Valid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Diagnostico;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.DiagnosticoDao;

/**
 * Clase engargada de realizar todas las operaciones de Diagnosticos en la BBDD
 * 
 * @author Rafael Justo
 *
 */
@Repository
public class DiagnosticoDaoImpl implements DiagnosticoDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Devuelve una lista de diagnosticos de la BBDD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Diagnostico> findAll() throws DaoException {
		List<Diagnostico> diag = null;
		try {
			String hql = "FROM Cita";
			diag = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return diag;
	}

	/**
	 * Busca un diagnostico de la BBDD a traves de un id dado
	 */
	@Override
	public Diagnostico findById(int id) throws DaoException {
		Diagnostico diagnostico = null;
		try {
			diagnostico = (Diagnostico) sessionFactory.getCurrentSession().get(Diagnostico.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return diagnostico;
	}

	/**
	 * Metodo que se encargar de guardar un Diagnostico en la BBDD
	 */
	@Override
	public void save(@Valid Diagnostico diagnostico) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(diagnostico);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Metodo que se encarga de modificar un diagnostico de la BBDD
	 */
	@Override
	public void update(@Valid Diagnostico diagnostico) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(diagnostico);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}
}
