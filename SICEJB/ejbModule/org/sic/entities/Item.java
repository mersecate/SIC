package org.sic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import bo.ItemBO;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "consultarAllItems", query = "SELECT i FROM Item i WHERE i.esAplicacion = true AND i.estado = true") })
@Table(name = "core_item")
public class Item implements Serializable {

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
	@SequenceGenerator(name = "core_item_seq", sequenceName = "core_item_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id_item", nullable = false)
	private long idItem;

	@Column(name = "url_item", nullable = true)
	private String urlItem;

	@Column(name = "titulo", nullable = true)
	private String titulo;

	@Column(name = "orden", nullable = true)
	private int orden;

	@Column(name = "icono", nullable = true)
	private String icono;

	@Column(name = "modulo", nullable = true)
	private String modulo;

	@Column(name = "es_aplicacion", nullable = true)
	private boolean esAplicacion;

	@Column(name = "estado", nullable = true)
	private boolean estado;

	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Item> items;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public Item() {
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

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	/**
	 * 
	 * @return PeriodoReporteBO
	 */
	public ItemBO toBO() {
		ItemBO itemBO = new ItemBO();
		itemBO.setIdItem(idItem);
		itemBO.setUrlItem(urlItem);
		itemBO.setIcono(icono);
		itemBO.setOrden(orden);
		itemBO.setTitulo(titulo);
		itemBO.setModulo(modulo);
		itemBO.setEsAplicacion(esAplicacion);
		itemBO.setEstado(estado);

		Collection<ItemBO> itemBOs = new ArrayList<ItemBO>();
		for (Item item : items)
			itemBOs.add(item.toBO());

		itemBO.setItemBOs(itemBOs);
		return itemBO;
	}

}
