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
import java.util.Map.Entry;
//import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Stateless
@TransactionAttribute( TransactionAttributeType.MANDATORY )
public class CRUDServiceBean<T> implements CRUDService<T> {

	
	//--------------------------------
	//Atributos de la Clase.
	//--------------------------------
	
	
	/**
	 * Gestiona la persistencia de datos.
	 */
	@PersistenceContext( unitName = "myEntityManager" )
	private EntityManager em;
	
	
	//--------------------------------
	//Constructor de la Clase.
	//--------------------------------

	
	/**
	 * Constructor por defecto.
	 */
	public CRUDServiceBean( ){}
	
	
	//--------------------------------
	//Métodos de la Clase.
	//--------------------------------
	
	
	/**
	 * create
	 */
	public T create( T t ) {
		
		this.em.persist( t );
		this.em.flush( );
		this.em.refresh( t );
				
		return t;
	}

	
	
	/**
	 * update
	 */
	public T update( T t ) {
		return ( T ) this.em.merge( t );
	}
	
	
	/**
	 * delete
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delete( Class tipoClase, Object id ) {
		
		Object ref = this.em.getReference( tipoClase , id );
		this.em.remove( ref );
	}

	
	/**
	 * find
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T find( Class tipoClase, Object id ) {
		return ( T ) this.em.find( tipoClase, id );
	}
	
	
	/**
	 * findWithNamedQuery
	 */
	@SuppressWarnings({ "rawtypes" })
	public List findWithNamedQuery( String nombreConsulta ) {
		return this.em.createNamedQuery( nombreConsulta ).getResultList( );
	}
		
	
	/**
	 * findWithNamedQuery : parameters
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findWithNamedQuery( String nombreConsulta, Map parameters ){
		Set<Entry<String, Object>> rawParameters = parameters.entrySet( );
		
		Query query = this.em.createNamedQuery( nombreConsulta );
		
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter( entry.getKey( ), entry.getValue( ) );
		}
		return query.getResultList( );
	}


	@Override
	public long countWithNamedQuery(String nombreConsulta) {
		Query query = this.em.createNamedQuery( nombreConsulta );
		long count = (long) query.getSingleResult();
		return count;
	}
	
	


}
