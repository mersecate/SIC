/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 20/10/2014
 */
package org.sic.crud.interfaz;

import java.util.Collection;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

import bo.TestBO;

/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Local
public interface IServiciosCRUDTest {

	// --------------------------------
	// Servicios de la Interface.
	// --------------------------------

	public TestBO crear(TestBO testBO) throws SICException;

	public TestBO modificar(TestBO testBO) throws SICException;

	public TestBO buscar(long idTestBO) throws SICException;
	
	public Collection<TestBO> consultarAllTest() throws SICException;

}
