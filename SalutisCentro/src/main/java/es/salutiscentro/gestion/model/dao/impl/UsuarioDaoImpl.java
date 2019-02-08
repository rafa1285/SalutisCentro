package es.salutiscentro.gestion.model.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Usuario;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.UsuarioDao;

/**
 * Clase engargada de realizar todas las operaciones con los Usuarios en la BBDD
 * 
 * @author Rafael Justo
 *
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Metodo encargado de buscar a un usuario en la BBDD a traves de su nombre y
	 * contraseña
	 */
	@Override
	public Usuario findByUsernameAndPassword(String username, String password) throws DaoException {
		Usuario user = null;
		try {
			String hql = "FROM Usuario u WHERE u.username=:username AND u.password=:password";
			user = (Usuario) sessionFactory.getCurrentSession().createQuery(hql).setParameter("username", username)
					.setParameter("password", password).uniqueResult();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return user;
	}

	/**
	 * Metodo encargado de guardar un usuario en la BBDD
	 */
	@Override
	public void save(Usuario item) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(item);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

}
