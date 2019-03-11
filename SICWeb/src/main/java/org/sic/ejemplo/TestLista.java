/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Derecho al Turno.
 * Autores:
 * 	        Gonzalo Mej�a Zapata
 * Fecha: 16-Sep-2014
 */
package org.sic.ejemplo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.sic.exceptions.SICException;
import org.sic.servicios.interfaz.IServiciosTest;

import bo.TestBO;

/**
 * @author Gonzalo Mejia Zapata
 *
 */
@Named
@ViewScoped
public class TestLista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IServiciosTest serviciosTest;

	private List<TestBO> testBOs;

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
	public TestLista() {
	}

	/**
	 * @return the testBOs
	 */
	public List<TestBO> getTestBOs() {
		return testBOs;
	}

	/**
	 * @param testBOs the testBOs to set
	 */
	public void setTestBOs(List<TestBO> testBOs) {
		this.testBOs = testBOs;
	}

	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct TestLista");
		testBOs = new ArrayList<TestBO>();
		try {
			testBOs = (List<TestBO>) serviciosTest.consultar();
		} catch (SICException e) {
			e.printStackTrace();
		}

	}

	public void eliminar() {
		System.out.println("Eliminar");
	}

}
