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

import bo.ItemBO;
import bo.RolBO;

/**
 * @author Gonzalo Mejía Zapata
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
