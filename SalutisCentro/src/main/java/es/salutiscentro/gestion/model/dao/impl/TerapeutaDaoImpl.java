package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.TerapeutaDao;

/**
 * Clase engargada de realizar todas las operaciones con Terapeutas en la BBDD
 * 
 * @author Rafael Justo
 *
 */
@Repository
public class TerapeutaDaoImpl implements TerapeutaDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Metodo encargado de mostrar todos los terapeutas de la BBDD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Terapeuta> findAll() throws DaoException {
		List<Terapeuta> tera = null;
		try {
			String hql = "FROM Terapeuta";
			tera = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return tera;
	}

	/**
	 * Metodo encargado de extraer de la BBDD a un Terapeuta a traves de un id dado
	 */
	@Override
	public Terapeuta findById(int id) throws DaoException {
		Terapeuta tera = null;
		try {
			tera = (Terapeuta) sessionFactory.getCurrentSession().get(Terapeuta.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return tera;
	}

	/**
	 * Metodo encargado de guardar un Terapeuta en la BBDD
	 */
	@Override
	public void save(Terapeuta terapeuta) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(terapeuta);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Metodo encargado de modificar un terapeuta de la BBDD
	 */
	@Override
	public void update(Terapeuta terapeuta) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(terapeuta);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Metodo encargado de borrar un terapeuta de la BBDD
	 */
	@Override
	public void delete(Terapeuta tera) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(tera);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

}
