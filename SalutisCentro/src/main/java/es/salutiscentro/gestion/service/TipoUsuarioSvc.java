package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.TipoUsuario;

public interface TipoUsuarioSvc {

	public Iterable<TipoUsuario> listar() throws SvcException;

}
