package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Usuario;

public interface UsuarioSvc {

	public Usuario identificar(Usuario usuario) throws SvcException;

	public boolean comprobar(Usuario usuario, String uri) throws SvcException;

	public void guardar(Usuario item) throws SvcException;
}
