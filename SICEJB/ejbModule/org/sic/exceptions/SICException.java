package org.sic.exceptions;
/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mejía Zapata
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
	 * Constante de Serialización.
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
	 * Constructor con parámetros.
	 * @param mensaje
	 */
	public SICException( String mensaje ){
		super( mensaje );
	}

	
	/**
	 * Constructor con parámetros.
	 * @param cause
	 */
	public SICException( Throwable cause ){
		super( cause );
	}
	
	
	/**
	 * Constructor con parámetros.
	 * @param mensaje
	 * @param cause
	 */
	public SICException( String mensaje, Throwable cause ){
		super( mensaje, cause );
	}
	
}
