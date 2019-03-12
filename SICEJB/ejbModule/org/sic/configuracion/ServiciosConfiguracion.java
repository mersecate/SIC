/**
 * Geoplaneación SAS.
 * Autor: Alfonso Rodríguez Suárez, MsC.
 * Fecha: 31-Oct-2015
 */
package org.sic.configuracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.sic.entities.Item;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosRol;
import org.sic.servicios.interfaz.IServiciosUsuario;

import bo.ItemBO;
import bo.RolBO;
import bo.UsuarioBO;

/**
 * @author ALFONSO
 *
 */

@Singleton
@Startup
public class ServiciosConfiguracion implements IServiciosConfiguracion {

	// --------------------------------
	// Atributos de la clase.
	// --------------------------------

	@EJB
	private IServiciosRol serviciosRol;
	
	@EJB
	private IServiciosUsuario serviciosUsuario;

	/**
	 * 
	 */
	public ServiciosConfiguracion() {
	}

	// --------------------------------
	// Métodos de la clase.
	// --------------------------------

	/**
	 * @throws IOException
	 * 
	 */
	@PostConstruct
	public void instalacion() throws SICException, IOException {
		
		ItemBO itemBO = new ItemBO( );
		itemBO.setUrlItem("");
		itemBO.setTitulo("Test");
		itemBO.setOrden(1);
		itemBO.setIcono("test.png");
		itemBO.setModulo("pages");
		itemBO.setEsAplicacion(true);
		itemBO.setEstado( true );
		
		itemBO = serviciosRol.crear(itemBO);
		
		ItemBO itemSubBO = new ItemBO( );
		itemSubBO.setUrlItem("testLista.xhtml");
		itemSubBO.setTitulo("Test");
		itemSubBO.setOrden(1);
		itemSubBO.setIcono("test.png");
		itemSubBO.setModulo("pages");
		itemSubBO.setEsAplicacion(false);
		itemSubBO.setEstado( true );
		itemSubBO = serviciosRol.crear(itemSubBO);
		
		Collection<ItemBO> itemBOs = new ArrayList<ItemBO>( );
		itemBOs.add( itemSubBO );
		itemBO.setItemBOs(itemBOs);
		
		itemBO = serviciosRol.modificar(itemBO);

		System.out.println("Core instalacion.....");
		
		if (serviciosRol.consultar().size() == 0) {
			Collection<ItemBO> itemBOsTmp = serviciosRol.consultarItems();
			RolBO rolBO = new RolBO();
			rolBO.toJson(itemBOsTmp);
			rolBO.setNombre("ADMINISTRADOR");
			RolBO rolBODB = serviciosRol.crear(rolBO);

			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.setEmail("gozlomejia@gmail.com");
			usuarioBO.setNombre("Chalo");
			usuarioBO.setPassword("123456");
			usuarioBO.setRolBO(rolBODB);

			serviciosUsuario.crear(usuarioBO);
		} else {
			RolBO rolBO = serviciosRol.buscar(1);
			Collection<ItemBO> itemBOsTmp = serviciosRol.consultarItems();
			rolBO.toJson(itemBOsTmp);
			serviciosRol.modificar(rolBO);
		}
	}

}
