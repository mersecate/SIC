/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 24-Sep-2014
 */
package org.sic.persistence.jpa;

import java.util.HashMap;
import java.util.Map;


public class QueryParameter {
	
	
	//--------------------------------
	//Atributos de la Clase.
	//--------------------------------
	
	
	/**
	 * Tabla de Par�metros de la consulta.
	 */
	private Map<String, Object> parameters = null;

	
	//--------------------------------
	//Constructor de la Clase.
	//--------------------------------
	
	/**
	 * Constructor de la Clase.
	 * @param name Nombre del par�metro.
	 * @param value Valor del par�metro.
	 */
	public QueryParameter(  ){

	}
	
	/**
	 * Constructor de la Clase.
	 * @param name Nombre del par�metro.
	 * @param value Valor del par�metro.
	 */
	private QueryParameter( String name, Object value ){
		this.parameters = new HashMap<String, Object>( );
		this.parameters.put( name, value );
	}
	
	
	//--------------------------------
	//M�todos de la Clase.
	//--------------------------------
	
	
	/**
	 * Pone el primer par�metro a la tabla de par�metros de la consulta.
	 * @param name Nombre del par�metro.
	 * @param value Valor del Par�metro.
	 * @return {@link QueryParameter}
	 */
	public static QueryParameter with( String name, Object value ){
		return new QueryParameter( name, value );
	}
	
	
	/**
	 * Agrega un par�metro a la tabla de par�metros.
	 * @param name Nombre del par�metro.
	 * @param value Valor del par�metro.
	 * @return {@link QueryParameter}
	 */
	public QueryParameter and( String name, Object value ){
		this.parameters.put( name, value );
		return this;
	}
	
	
	/**
	 * Retorna la tabla de par�metros.
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map parameters( ){
		return this.parameters;
	}
	
}
