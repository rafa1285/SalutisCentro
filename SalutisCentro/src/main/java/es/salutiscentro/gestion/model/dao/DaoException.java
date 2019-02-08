package es.salutiscentro.gestion.model.dao;

/**
 * Clase que se encarga de recoger los errores provenientes de los Daos.
 * 
 * @author Rafael Justo
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = -9128710675661571854L;

	public DaoException(Exception ex) {
		super(ex);
	}

}
