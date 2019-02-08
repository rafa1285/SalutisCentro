package es.salutiscentro.gestion.model.dao;

import javax.validation.Valid;
import es.salutiscentro.gestion.model.Diagnostico;

public interface DiagnosticoDao {

	public Iterable<Diagnostico> findAll() throws DaoException;

	public Diagnostico findById(int id) throws DaoException;

	public void save(@Valid Diagnostico diagnostico) throws DaoException;

	public void update(@Valid Diagnostico diagnostico) throws DaoException;

}
