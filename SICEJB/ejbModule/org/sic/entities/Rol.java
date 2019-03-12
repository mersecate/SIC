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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import bo.RolBO;

@Entity
@NamedQueries(value = { @NamedQuery(name = "consultarAllRol", query = "SELECT r FROM Rol r") })
@Table(name = "core_rol")
public class Rol implements Serializable {

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
	@SequenceGenerator(name = "core_rol_seq", sequenceName = "core_rol_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id_rol", nullable = false)
	private long idRol;

	@Column(name = "nombre_rol", nullable = false)
	private String nombre;

	@Column(name = "menu", nullable = true)
	@Lob
	private byte[] menu;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public Rol() {
	}

	public long getIdRol() {
		return idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getMenu() {
		return menu;
	}

	public void setMenu(byte[] menu) {
		this.menu = menu;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	/**
	 * 
	 * @return PeriodoReporteBO
	 */
	public RolBO toBO() {
		RolBO rolBO = new RolBO();
		rolBO.setIdRol(idRol);
		rolBO.setNombre(nombre);
		rolBO.setMenu(menu);
		return rolBO;
	}

}
