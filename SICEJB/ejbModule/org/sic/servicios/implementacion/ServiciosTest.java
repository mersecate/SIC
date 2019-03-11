/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 29/06/2017
 */
package org.sic.servicios.implementacion;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.sic.crud.interfaz.IServiciosCRUDTest;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosTest;

import bo.TestBO;


/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Stateless
public class ServiciosTest implements IServiciosTest {

	@EJB
	private IServiciosCRUDTest serviciosCRUDTest;

	public TestBO crear(TestBO testBO) throws SICException {
		return this.serviciosCRUDTest.crear(testBO);
	}

	public TestBO modificar(TestBO testBO) throws SICException {
		return this.serviciosCRUDTest.modificar(testBO);
	}

	public TestBO buscar(long idTestBO) throws SICException {
		return this.serviciosCRUDTest.buscar(idTestBO);
	}

	public Collection<TestBO> consultar() throws SICException {
		return this.serviciosCRUDTest.consultarAllTest();
	}

}
