package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.Usuario;

public interface UsuarioDao {

	public Usuario findByUsernameAndPassword(String username, String password) throws DaoException;

	public void save(Usuario item) throws DaoException;
}
