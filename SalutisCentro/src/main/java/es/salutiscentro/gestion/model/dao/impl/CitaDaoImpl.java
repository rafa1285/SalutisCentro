package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Cita;
import es.salutiscentro.gestion.model.dao.CitaDao;
import es.salutiscentro.gestion.model.dao.DaoException;

/**
 * Clase engargada de realizar todas las operaciones con Citas en la BBDD
 * 
 * @author Rafael Justo
 *
 */
@Repository
public class CitaDaoImpl implements CitaDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Devuelve todas las citas de la BBDD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Cita> findAll() throws DaoException {
		List<Cita> cita = null;
		try {
			String hql = "FROM Cita";
			cita = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return cita;
	}

	/**
	 * Guarda una cita en la BBDD
	 */
	@Override
	public void save(Cita cita) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(cita);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Modifica una cita en la BBDD
	 */
	@Override
	public void update(Cita cita) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(cita);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Busca una cita a traves de un id dado
	 */
	@Override
	public Cita findById(int id) throws DaoException {
		Cita cita = null;
		try {
			cita = (Cita) sessionFactory.getCurrentSession().get(Cita.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return cita;
	}
}
