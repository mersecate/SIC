/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 16-Sep-2014
 */
package org.sic.ejemplo;

import static com.github.adminfaces.template.util.Assert.has;
import static org.sic.util.Utils.addDetailMessage;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosTest;

import bo.TestBO;

/**
 * @author Gonzalo Mejia Zapata
 *
 */
@Named
@ViewScoped
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IServiciosTest serviciosTest;

	/**
	 * 
	 */

	private long id;

	private TestBO testBO;

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
	public Test() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the testBO
	 */
	public TestBO getTestBO() {
		return testBO;
	}

	/**
	 * @param testBO the testBO to set
	 */
	public void setTestBO(TestBO testBO) {
		this.testBO = testBO;
	}

	public void init() {
		System.out.println("init Test");
		if (Faces.isAjaxRequest()) {
			return;
		}
		testBO = new TestBO();
		if (has(id)) {
			try {
				if (id != 0)
					testBO = serviciosTest.buscar(id);
			} catch (SICException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// --------------------------------
	// seters y geters.
	// --------------------------------

	public void guardar() {
		try {
			String msg;
			if (testBO.getIdTest( ) == 0) {
				testBO = serviciosTest.crear(testBO);
				msg = "Test " + testBO.getIdTest( ) + " creado";
			} else {
				testBO = serviciosTest.modificar(testBO);
				msg = "Test " + testBO.getIdTest( ) + " actualizado";
			}
			addDetailMessage(msg);
		} catch (SICException e) {
			e.printStackTrace();
		}
	}

}
