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
import java.util.Collection;

public class ItemBO implements Serializable {

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

	private long idItem;

	private String urlItem;

	private String titulo;

	private int orden;

	private String icono;

	private String modulo;

	private String url;

	private boolean esAplicacion;

	private boolean estado;

	private Collection<ItemBO> itemBOs;
	
	private int tieneHijos;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public ItemBO() {
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public String getUrlItem() {
		return urlItem;
	}

	public void setUrlItem(String urlItem) {
		this.urlItem = urlItem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isEsAplicacion() {
		return esAplicacion;
	}

	public void setEsAplicacion(boolean esAplicacion) {
		this.esAplicacion = esAplicacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Collection<ItemBO> getItemBOs() {
		return itemBOs;
	}

	public void setItemBOs(Collection<ItemBO> itemBOs) {
		this.itemBOs = itemBOs;
	}
	
	public void setTieneHijos(int tieneHijos) {
		this.tieneHijos = tieneHijos;
	}
	
	public int getTieneHijos() {
		return tieneHijos;
	}
	
	
	public void toHijos( ) {
		if( itemBOs != null && itemBOs.size( ) > 0 )
			this.tieneHijos = 1;
		else
			this.tieneHijos = 0;
	}
	
	public void toURL( ) {
		if( urlItem != null && urlItem.length() != 0 && !urlItem.equals("") )
			this.url = "/" + modulo + "/" + urlItem.replaceAll(".xhtml", "" );
		else
			this.url = "/index";
	}
	
}
