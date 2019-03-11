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

import bo.UsuarioBO;


/**
 * @author Gonzalo Mejía Zapata
 *
 */
@Local
public interface IServiciosUsuario {

	public UsuarioBO crear(UsuarioBO usuarioBO) throws SICException;

	public UsuarioBO modificar(UsuarioBO sociedadBO) throws SICException;

	public UsuarioBO buscar(long idUsuarioBO) throws SICException;

	public UsuarioBO buscar(UsuarioBO usuarioBO) throws SICException;

	public Collection<UsuarioBO> consultar() throws SICException;

}
