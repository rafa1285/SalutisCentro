package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Especialidad;

public interface EspecialidadSvc {

	public Iterable<Especialidad> listar() throws SvcException;

}
