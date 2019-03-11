/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 29/06/2017
 */
package org.sic.servicios.interfaz;

import java.util.Collection;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

import bo.TestBO;


/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Local
public interface IServiciosTest {

	public TestBO crear(TestBO testBO) throws SICException;

	public TestBO modificar(TestBO testBO) throws SICException;

	public TestBO buscar(long idTestBO) throws SICException;

	public Collection<TestBO> consultar() throws SICException;

}
