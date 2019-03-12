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

import org.sic.crud.interfaz.IServiciosCRUDRol;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosRol;

import bo.ItemBO;
import bo.RolBO;

/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Stateless
public class ServiciosRol implements IServiciosRol {

	@EJB
	private IServiciosCRUDRol serviciosCRUDRol;

	public Collection<RolBO> consultar() throws SICException {
		return this.serviciosCRUDRol.consultarAllRol();
	}

	@Override
	public RolBO crear(RolBO rolBO) throws SICException {
		return this.serviciosCRUDRol.crear(rolBO);
	}

	@Override
	public RolBO modificar(RolBO rolBO) throws SICException {
		return this.serviciosCRUDRol.modificar(rolBO);
	}

	@Override
	public RolBO buscar(long idRolBO) throws SICException {
		return this.serviciosCRUDRol.buscar(idRolBO);
	}

	@Override
	public Collection<ItemBO> consultarItems() throws SICException {
		return this.serviciosCRUDRol.consultarAllItems();
	}

	@Override
	public ItemBO crear(ItemBO itemBO) throws SICException {
		return this.serviciosCRUDRol.crear(itemBO);
	}

	@Override
	public ItemBO modificar(ItemBO itemBO) throws SICException {
		return this.serviciosCRUDRol.modificar(itemBO);
	}

}
