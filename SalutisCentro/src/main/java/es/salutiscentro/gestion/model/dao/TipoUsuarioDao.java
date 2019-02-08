package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.TipoUsuario;

public interface TipoUsuarioDao {

	public Iterable<TipoUsuario> findAll() throws DaoException;

}
