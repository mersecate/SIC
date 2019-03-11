/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 16-Sep-2014
 */
package org.sic.core.login;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosRol;

import bo.ItemBO;
import bo.RolBO;
import bo.UsuarioBO;

@Named
@ViewScoped
public class Menu implements Serializable {

	/**
	 * 
	 */
	@EJB
	private IServiciosRol serviciosRol;

	private static final long serialVersionUID = 1L;

	private String nombreUsuario = "Chalo";

	private List<ItemBO> itemBOs;

	private String url;

	// --------------------------------
	// Constantes de la clase.
	// --------------------------------

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por defecto.
	 */
	public Menu() {
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setItemBOs(List<ItemBO> itemBOs) {
		this.itemBOs = itemBOs;
	}

	public List<ItemBO> getItemBOs() {
		return itemBOs;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct Menu");

		RolBO rolBO = new RolBO();
		try {
			long idRol = 1;
			rolBO = serviciosRol.buscar(idRol);
		} catch (SICException e) {
			e.printStackTrace();
		}

		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.setRolBO(rolBO);

		itemBOs = (List<ItemBO>) usuarioBO.getRolBO().toMenu();
	}


}
