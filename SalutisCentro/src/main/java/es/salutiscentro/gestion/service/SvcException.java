package es.salutiscentro.gestion.service;

/**
 * Clase encargada de capturar los errores causados por los servicios
 * 
 * @author Rafael Justo
 *
 */
public class SvcException extends Exception {

	private static final long serialVersionUID = 3840469229784793572L;

	public SvcException(Exception ex) {
		super(ex);
	}

}
