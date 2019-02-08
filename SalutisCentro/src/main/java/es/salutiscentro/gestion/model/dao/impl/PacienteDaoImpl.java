package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.PacienteDao;

/**
 * Clase engargada de realizar todas las operaciones con Pacientes en la BBDD
 * 
 * @author Rafael Justo
 *
 */
@Repository
public class PacienteDaoImpl implements PacienteDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Metodo encargado de guardar Pacientes en la BBDD
	 */
	@Override
	public void save(Paciente paciente) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(paciente);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Metodo encargado de modificar un paciente en la BBDD
	 */
	@Override
	public void update(Paciente paciente) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(paciente);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * Metodo encargado de extraer todos los pacientes de la BBDD a traves de un
	 * nombre dado
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Paciente> findByNombre(String nombre) throws DaoException {
		List<Paciente> paci = null;
		try {
			String hql = "FROM Paciente p WHERE p.nombre LIKE :nombre";
			paci = sessionFactory.getCurrentSession().createQuery(hql).setParameter("nombre", "%" + nombre + "%")
					.list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return paci;
	}

	/**
	 * Metodo encargado de extraer un paciente de la BBDD a traves de un id dado
	 */
	@Override
	public Paciente findById(int id) throws DaoException {
		Paciente paci = null;
		try {
			paci = (Paciente) sessionFactory.getCurrentSession().get(Paciente.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return paci;
	}

	/**
	 * Metodo encargado de borrar un paciente de la BBDD
	 */
	@Override
	public void delete(Paciente paci) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(paci);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

}
