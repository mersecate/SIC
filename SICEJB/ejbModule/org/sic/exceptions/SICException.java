package org.sic.exceptions;
/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 2-Sep-2014
 */


/**
 * Clase que permite gestionar las excepciones del sistema.
 *
 */
public class SICException extends Exception{

	
	//--------------------------------
	//Constantes de la Clase.
	//--------------------------------
	
	
	/**
	 * Constante de Serializaci�n.
	 */
	private static final long serialVersionUID = 572860491972449066L;

	
	//--------------------------------
	//Constructores de la clase.
	//--------------------------------
	
	
	/**
	 * Constructor por defecto.
	 */
	public SICException( ){
		super( );
	}
	
	
	/**
	 * Constructor con par�metros.
	 * @param mensaje
	 */
	public SICException( String mensaje ){
		super( mensaje );
	}

	
	/**
	 * Constructor con par�metros.
	 * @param cause
	 */
	public SICException( Throwable cause ){
		super( cause );
	}
	
	
	/**
	 * Constructor con par�metros.
	 * @param mensaje
	 * @param cause
	 */
	public SICException( String mensaje, Throwable cause ){
		super( mensaje, cause );
	}
	
}
