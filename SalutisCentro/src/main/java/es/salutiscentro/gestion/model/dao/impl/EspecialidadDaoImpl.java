package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Especialidad;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.EspecialidadDao;

/**
 * Clase engargada de realizar todas las operaciones con Especialidades en la BBDD
 * @author Rafael Justo
 *
 */
@Repository
public class EspecialidadDaoImpl implements EspecialidadDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Metodo encargado de extraer las Especialidades de la BBDD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Especialidad> findAll() throws DaoException {
		List<Especialidad> res = null;
		try {
			String hql = "FROM Especialidad";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return res;
	}
}
