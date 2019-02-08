package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.Terapeuta;

public interface TerapeutaDao {

	public Iterable<Terapeuta> findAll() throws DaoException;

	public Terapeuta findById(int id) throws DaoException;

	public void save(Terapeuta terapeuta) throws DaoException;

	public void update(Terapeuta terapeuta) throws DaoException;

	public void delete(Terapeuta tera) throws DaoException;

}
