/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOG�A E INFORM�TICA.
 * Proyecto: Sistema de Gesti�n de Estudios Previos.
 * Autores:
 * 	        Javier S�nchez Mu�oz
 * 			Alfonso Rodr�guez Su�rez
 * Fecha: 03-Nov-2016
 */
package bo;

import java.io.Serializable;

public class UsuarioBO implements Serializable {

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

	private long idUsuario;

	private String nombre;

	private String email;

	private String password;

	private RolBO rolBO;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public UsuarioBO() {
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

	public RolBO getRolBO() {
		return rolBO;
	}

	public void setRolBO(RolBO rolBO) {
		this.rolBO = rolBO;
	}

}
