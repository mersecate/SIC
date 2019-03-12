/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 20/10/2014
 */
package org.sic.crud.implementacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import bo.UsuarioBO;
import org.sic.crud.interfaz.IServiciosCRUDUsuario;
import org.sic.entities.Rol;
import org.sic.entities.Usuario;
import org.sic.exceptions.SICException;
import org.sic.persistence.jpa.CRUDService;

/**
 * @author Gonzalo Mej�a Zapata
 *
 */
@Stateless
public class ServiciosCRUDUsuario implements IServiciosCRUDUsuario {

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	/**
	 * Servicios CRUD para las cuentas.
	 */
	@EJB
	private CRUDService<Usuario> crudService;

	// --------------------------------
	// M�todos de la Clase.
	// --------------------------------

	public UsuarioBO crear(UsuarioBO usuarioBO) throws SICException {

		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioBO.getEmail());
		usuario.setNombre(usuarioBO.getNombre());
		usuario.setPassword(usuarioBO.getPassword());

		Rol rol = new Rol();
		rol.setIdRol(usuarioBO.getRolBO().getIdRol());

		usuario.setRol(rol);

		return crudService.create(usuario).toBO();
	}

	public UsuarioBO modificar(UsuarioBO usuarioBO) throws SICException {

		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioBO.getEmail());
		usuario.setNombre(usuarioBO.getNombre());
		usuario.setPassword(usuarioBO.getPassword());
		usuario.setIdUsuario(usuarioBO.getIdUsuario());

		Rol rol = new Rol();
		rol.setIdRol(usuarioBO.getRolBO().getIdRol());

		usuario.setRol(rol);

		return crudService.update(usuario).toBO();
	}

	public UsuarioBO buscar(long idUsuarioBO) throws SICException {
		return this.crudService.find(Usuario.class, idUsuarioBO).toBO();
	}

	@SuppressWarnings("unchecked")
	public UsuarioBO buscar(UsuarioBO usuarioBO) throws SICException {
		UsuarioBO usuarioBODB = null;

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("email", usuarioBO.getEmail());
		parametros.put("password", usuarioBO.getPassword());

		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.crudService.findWithNamedQuery("buscarUsuarioUserPass",
				parametros);

		if (usuarios.size() > 0)
			usuarioBODB = usuarios.get(0).toBO();
		return usuarioBODB;

	}

	@SuppressWarnings("unchecked")
	public Collection<UsuarioBO> consultarAllUsuario() throws SICException {
		Collection<UsuarioBO> usuarioBOs = new ArrayList<UsuarioBO>();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.crudService.findWithNamedQuery("consultarAllUsuario");
		for (Usuario usuario : usuarios)
			usuarioBOs.add(usuario.toBO());
		return usuarioBOs;

	}

}
