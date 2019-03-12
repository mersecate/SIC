/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mejía Zapata
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
	 * Tabla de Parámetros de la consulta.
	 */
	private Map<String, Object> parameters = null;

	
	//--------------------------------
	//Constructor de la Clase.
	//--------------------------------
	
	/**
	 * Constructor de la Clase.
	 * @param name Nombre del parámetro.
	 * @param value Valor del parámetro.
	 */
	public QueryParameter(  ){

	}
	
	/**
	 * Constructor de la Clase.
	 * @param name Nombre del parámetro.
	 * @param value Valor del parámetro.
	 */
	private QueryParameter( String name, Object value ){
		this.parameters = new HashMap<String, Object>( );
		this.parameters.put( name, value );
	}
	
	
	//--------------------------------
	//Métodos de la Clase.
	//--------------------------------
	
	
	/**
	 * Pone el primer parámetro a la tabla de parámetros de la consulta.
	 * @param name Nombre del parámetro.
	 * @param value Valor del Parámetro.
	 * @return {@link QueryParameter}
	 */
	public static QueryParameter with( String name, Object value ){
		return new QueryParameter( name, value );
	}
	
	
	/**
	 * Agrega un parámetro a la tabla de parámetros.
	 * @param name Nombre del parámetro.
	 * @param value Valor del parámetro.
	 * @return {@link QueryParameter}
	 */
	public QueryParameter and( String name, Object value ){
		this.parameters.put( name, value );
		return this;
	}
	
	
	/**
	 * Retorna la tabla de parámetros.
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map parameters( ){
		return this.parameters;
	}
	
}
