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

import bo.ItemBO;
import bo.RolBO;

/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Local
public interface IServiciosCRUDRol {

	// --------------------------------
	// Servicios de la Interface.
	// --------------------------------

	public RolBO crear(RolBO rolBO) throws SICException;

	public RolBO modificar(RolBO rolBO) throws SICException;

	public RolBO buscar(long idRolBO) throws SICException;

	public Collection<RolBO> consultarAllRol() throws SICException;

	public ItemBO crear(ItemBO itemBO) throws SICException;

	public ItemBO modificar(ItemBO itemBO) throws SICException;

	public Collection<ItemBO> consultarAllItems() throws SICException;

}
