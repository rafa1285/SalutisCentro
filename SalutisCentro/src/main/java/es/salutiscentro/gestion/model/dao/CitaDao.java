package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.Cita;

public interface CitaDao {

	public Iterable<Cita> findAll() throws DaoException;

	public void save(Cita cita) throws DaoException;

	public void update(Cita cita) throws DaoException;

	public Cita findById(int id) throws DaoException;

}
