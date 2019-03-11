/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Estudios Previos.
 * Autores:
 * 	        Javier S�nchez Mu�oz
 * 			Alfonso Rodr�guez Su�rez
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

@NamedQueries(value = { @NamedQuery(name = "consultarAllTest", query = "SELECT t FROM Test t") })
@Entity
@Table(name = "core_test")
public class Test implements Serializable {

	// --------------------------------
	// Constantes de la Clase.
	// --------------------------------

	/**
	 * Constante de Serializaci�n.
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

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "codigo", nullable = false)
	private String codigo;

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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public TestBO toBO() {
		TestBO testBO = new TestBO();
		testBO.setIdTest(idTest);
		testBO.setDescripcion(descripcion);
		testBO.setCodigo(codigo);
		return testBO;
	}

}
