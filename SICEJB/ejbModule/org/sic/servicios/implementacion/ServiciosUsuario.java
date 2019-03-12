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

import org.sic.crud.interfaz.IServiciosCRUDUsuario;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosUsuario;

import bo.UsuarioBO;

/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Stateless
public class ServiciosUsuario implements IServiciosUsuario {

	@EJB
	private IServiciosCRUDUsuario serviciosCRUDUsuario;

	public UsuarioBO crear(UsuarioBO usuarioBO) throws SICException {
		return this.serviciosCRUDUsuario.crear(usuarioBO);
	}

	public UsuarioBO modificar(UsuarioBO usuarioBO) throws SICException {
		return this.serviciosCRUDUsuario.modificar(usuarioBO);
	}

	public UsuarioBO buscar(UsuarioBO usuarioBO) throws SICException {
		return this.serviciosCRUDUsuario.buscar(usuarioBO);
	}

	public UsuarioBO buscar(long idUsuarioBO) throws SICException {
		return this.serviciosCRUDUsuario.buscar(idUsuarioBO);
	}

	public Collection<UsuarioBO> consultar() throws SICException {
		return this.serviciosCRUDUsuario.consultarAllUsuario();
	}

}
