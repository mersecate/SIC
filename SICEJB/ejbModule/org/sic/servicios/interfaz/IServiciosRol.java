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

import bo.ItemBO;
import bo.RolBO;

/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Local
public interface IServiciosRol {

	public RolBO crear(RolBO rolBO) throws SICException;

	public RolBO modificar(RolBO rolBO) throws SICException;

	public RolBO buscar(long idRolBO) throws SICException;

	public Collection<RolBO> consultar() throws SICException;

	public ItemBO crear(ItemBO itemBO) throws SICException;

	public ItemBO modificar(ItemBO itemBO) throws SICException;

	public Collection<ItemBO> consultarItems() throws SICException;

}
