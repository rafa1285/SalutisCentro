package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.TipoUsuario;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.TipoUsuarioDao;

/**
 * Clase engargada de realizar todas las operaciones con Tipo de Usuario en la
 * BBDD
 * 
 * @author Rafael Justo
 *
 */
@Repository
public class TipoUsuarioDaoImpl implements TipoUsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Metodo encargado de extraer los tipos de usuario de la BBDD
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<TipoUsuario> findAll() throws DaoException {
		List<TipoUsuario> tipoUser = null;
		try {
			String hql = "FROM TipoUsuario";
			tipoUser = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return tipoUser;
	}

}
