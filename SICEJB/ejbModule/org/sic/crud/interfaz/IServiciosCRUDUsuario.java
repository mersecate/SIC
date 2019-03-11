package org.sic.crud.interfaz;

import java.util.Collection;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

import bo.UsuarioBO;


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
