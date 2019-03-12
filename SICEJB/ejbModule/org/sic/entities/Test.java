/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Estudios Previos.
 * Autores:
 * 	        Javier Sánchez Muñoz
 * 			Alfonso Rodríguez Suárez
 * Fecha: 03-Nov-2016
 */
package org.sic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import bo.TestBO;

@Entity
@NamedQueries(value = { @NamedQuery(name = "consultarAllTest", query = "SELECT t FROM Test t") })
@Table(name = "core_test")
public class Test implements Serializable {

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "core_test_seq", sequenceName = "core_test_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id_test", nullable = false)
	private long idTest;

	@Column(name = "nombre_test", nullable = false)
	private String nombre;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public Test() {
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

	/**
	 * 
	 * @return PeriodoReporteBO
	 */
	public TestBO toBO() {
		TestBO testBO = new TestBO();
		testBO.setIdTest(idTest);
		testBO.setNombre(nombre);
		return testBO;
	}

}
