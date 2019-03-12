/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mejía Zapata
 * Fecha: 24-Sep-2014
 */

package org.sic.persistence.jpa;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;


@Local
public interface CRUDService<T> {

	
	//--------------------------------
	//Servicios de la Interface.
	//--------------------------------
	
	
	/**
	 * Crea una instancia de la entidad en la Base de Datos.
	 * @param t Entity que va a ser creada en la Base de Datos.
	 * @return Retorna la nueva entidad.
	 */
	public T create( T t );
	
	
	/**
	 * Busca la una instancia de una entidad por el Id en la base de datos.
	 * @param tipoClase Clase a la que pertenece la entidad a buscar.
	 * @param id Identificador de la entidad.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public T find( Class tipoClase, Object id );
	
	
	/**
	 * Permite actualizar los datos de una entidad en la base de datos.
	 * @param t Entidad a Actualizar.
	 * @return Entidad que se actualizó.
	 */
	public T update( T t );

	
	/**
	 * 
	 * @param tipoClase
	 * @param id
	 */
	@SuppressWarnings({ "rawtypes" })
	public void delete( Class tipoClase, Object id );

	
	/**
	 * Retorna el resultado de una consulta que no requiere parámetros.
	 * @param nombreConsulta Consulta en JPQL.
	 * @return {@link List} Lista de entidades.
	 */
	@SuppressWarnings("rawtypes")
	public List findWithNamedQuery( String nombreConsulta );
	
	
	/**
	 * Retorna el resultado de una consulta que requiere parámetros.
	 * @param nombreConsulta Nombre de la consulta.
	 * @param parametros Parámetros de la Consulta.
	 * @return {@link List} Lista de Entidades.
	 */
	@SuppressWarnings("rawtypes")
	public List findWithNamedQuery( String nombreConsulta, Map parametros );


	/**
	 * 
	 * @param nombreConsulta
	 * @return
	 */
	public long countWithNamedQuery( String nombreConsulta );

	
	/**
	 * 
	 * @param nombreConsulta
	 * @param parametros
	 * @return
	 */
	/*@SuppressWarnings("rawtypes")
	public List findWithNamedQuerySQL( String sql, Map parametros );*/
	
}
