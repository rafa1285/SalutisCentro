package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.Especialidad;

public interface EspecialidadDao {

	public Iterable<Especialidad> findAll() throws DaoException;

}
