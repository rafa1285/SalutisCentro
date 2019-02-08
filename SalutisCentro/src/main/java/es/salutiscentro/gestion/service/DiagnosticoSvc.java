package es.salutiscentro.gestion.service;

import javax.validation.Valid;
import es.salutiscentro.gestion.model.Diagnostico;

public interface DiagnosticoSvc {

	public Iterable<Diagnostico> listar() throws SvcException;

	public Diagnostico buscar(int id) throws SvcException;

	public void guardar(@Valid Diagnostico diagnostico) throws SvcException;

	public void modificar(@Valid Diagnostico diagnostico) throws SvcException;

}
