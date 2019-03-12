/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mejía Zapata
 * Fecha: 20/10/2014
 */
package org.sic.crud.interfaz;

import java.util.Collection;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

import bo.UsuarioBO;

/**
 * @author Gonzalo Mejía Zapata
 *
 */
@Local
public interface IServiciosCRUDUsuario {

	// --------------------------------
	// Servicios de la Interface.
	// --------------------------------

	public UsuarioBO crear(UsuarioBO usuarioBO) throws SICException;

	public UsuarioBO modificar(UsuarioBO usuarioBO) throws SICException;

	public UsuarioBO buscar(long idUsuarioBO) throws SICException;
	
	public UsuarioBO buscar(UsuarioBO usuarioBO) throws SICException;

	public Collection<UsuarioBO> consultarAllUsuario() throws SICException;

}
