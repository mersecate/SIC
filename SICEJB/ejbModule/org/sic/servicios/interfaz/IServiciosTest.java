/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mejía Zapata
 * Fecha: 29/06/2017
 */
package org.sic.servicios.interfaz;

import java.util.Collection;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

import bo.TestBO;


/**
 * @author Gonzalo Mejía Zapata
 *
 */
@Local
public interface IServiciosTest {

	public TestBO crear(TestBO testBO) throws SICException;

	public TestBO modificar(TestBO testBO) throws SICException;

	public TestBO buscar(long idTestBO) throws SICException;

	public Collection<TestBO> consultar() throws SICException;

}
