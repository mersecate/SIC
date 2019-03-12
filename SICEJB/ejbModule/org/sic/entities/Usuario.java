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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import bo.UsuarioBO;

@NamedQueries(value = { @NamedQuery(name = "consultarAllUsuario", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "buscarUsuarioUserPass", query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password") })
@Entity
@Table(name = "core_usuario")
public class Usuario implements Serializable {

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
	@SequenceGenerator(name = "core_usuario_seq", sequenceName = "core_usuario_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id_usuario", nullable = false)
	private long idUsuario;

	@Column(name = "nombre_usuario", nullable = false)
	private String nombre;

	@Column(name = "email_usuario", nullable = false)
	private String email;

	@Column(name = "password_usuario", nullable = false)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol", nullable = false, updatable = true)
	private Rol rol;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public Usuario() {
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * 
	 * @return PeriodoReporteBO
	 */
	public UsuarioBO toBO() {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.setIdUsuario(idUsuario);
		usuarioBO.setEmail(email);
		usuarioBO.setNombre(nombre);
		usuarioBO.setPassword(password);

		if (rol != null)
			usuarioBO.setRolBO(rol.toBO());

		return usuarioBO;
	}

}
