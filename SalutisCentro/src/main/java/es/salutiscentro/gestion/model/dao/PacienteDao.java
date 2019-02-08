package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.Paciente;

public interface PacienteDao {

	public void save(Paciente paciente) throws DaoException;

	public void update(Paciente paciente) throws DaoException;

	public Iterable<Paciente> findByNombre(String string) throws DaoException;

	public Paciente findById(int id) throws DaoException;

	public void delete(Paciente paci) throws DaoException;

}
