/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Estudios Previos.
 * Autores:
 * 	        Javier Sánchez Muñoz
 * 			Alfonso Rodríguez Suárez
 * Fecha: 03-Nov-2016
 */
package bo;

import java.io.Serializable;

public class TestBO implements Serializable {

	// --------------------------------
	// Constantes de la Clase.
	// --------------------------------

	/**
	 * Constante de Serialización.
	 */
	private static final long serialVersionUID = -6362794385792247263L;

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	private long idTest;

	private String nombre;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public TestBO() {
	}

	/**
	 * @return the idTest
	 */
	public long getIdTest() {
		return idTest;
	}

	/**
	 * @param idTest the idTest to set
	 */
	public void setIdTest(long idTest) {
		this.idTest = idTest;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
