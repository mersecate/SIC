package org.sic.configuracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosRol;
import org.sic.servicios.interfaz.IServiciosTest;
import org.sic.servicios.interfaz.IServiciosUsuario;

import bo.ItemBO;
import bo.RolBO;
import bo.TestBO;
import bo.UsuarioBO;

@Singleton
@Startup
public class ServiciosConfiguracion implements IServiciosConfiguracion {

	// --------------------------------
	// Atributos de la clase.
	// --------------------------------

	@Inject
	private IServiciosRol serviciosRol;

	@Inject
	private IServiciosUsuario serviciosUsuario;

	@Inject
	private IServiciosTest serviciosTest;

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

		ItemBO itemBOApp = new ItemBO();
		itemBOApp.setEsAplicacion(true);
		itemBOApp.setEstado(true);
		itemBOApp.setIcono("foto.png");
		itemBOApp.setModulo("pages");
		itemBOApp.setOrden(1);
		itemBOApp.setTitulo("Test-App");
		itemBOApp = serviciosRol.crear(itemBOApp);
		
		ItemBO itemBO = new ItemBO();
		itemBO.setEsAplicacion(false);
		itemBO.setEstado(true);
		itemBO.setIcono("foto.png");
		itemBO.setModulo("pages");
		itemBO.setOrden(1);
		itemBO.setTitulo("Test");
		itemBO.setUrl("testLista.xhtml");
		itemBO = serviciosRol.crear(itemBO);
		
		ArrayList<ItemBO> itemBOs = new ArrayList<ItemBO>();
		itemBOs.add(itemBO);
		itemBOApp.setItemBOs(itemBOs);
		
		itemBOApp = serviciosRol.modificar(itemBOApp);

		
		if (serviciosRol.consultar().size() == 0) {
			Collection<ItemBO> itemBOsTmp = serviciosRol.consultarItems();
			for (ItemBO itemBO2 : itemBOsTmp) {
				System.out.println("itemBO....." + itemBO2.getIdItem( ) );
			}
			
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
		
		for (int i = 0; i < 1000; i++) {
			TestBO testBO = new TestBO( );
			testBO.setDescripcion("Descripcion " + i);
			testBO.setCodigo("Codigo " + i);
			System.out.println( testBO.toString( ) );
			testBO = serviciosTest.crear(testBO);
			System.out.println( testBO.toString( ) );
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}
		
		
		

	}

}
