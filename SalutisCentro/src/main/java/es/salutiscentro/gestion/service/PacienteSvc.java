package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Paciente;

public interface PacienteSvc {

	public void guardar(Paciente paciente) throws SvcException;

	public void modificar(Paciente paciente) throws SvcException;

	public Iterable<Paciente> listar() throws SvcException;

	public Paciente buscar(int id) throws SvcException;

	public void eliminar(Paciente paci) throws SvcException;

}
