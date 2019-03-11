package org.sic.crud.interfaz;

import java.util.Collection;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

import bo.TestBO;


@Local
public interface IServiciosCRUDTest {

	// --------------------------------
	// Servicios de la Interface.
	// --------------------------------

	public TestBO crear(TestBO usuarioBO) throws SICException;

	public TestBO modificar(TestBO usuarioBO) throws SICException;

	public TestBO buscar(long idTestBO) throws SICException;
	
	public Collection<TestBO> consultarAllTest() throws SICException;

}
