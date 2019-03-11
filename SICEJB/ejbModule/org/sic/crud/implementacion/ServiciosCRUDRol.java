package org.sic.crud.implementacion;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.sic.crud.interfaz.IServiciosCRUDRol;
import org.sic.entities.Item;
import org.sic.entities.Rol;
import org.sic.exceptions.SICException;
import org.sic.persistence.jpa.CRUDService;

import bo.ItemBO;
import bo.RolBO;


@Stateless
public class ServiciosCRUDRol implements IServiciosCRUDRol {

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	/**
	 * Servicios CRUD para las cuentas.
	 */
	@EJB
	private CRUDService<Rol> crudService;

	@EJB
	private CRUDService<Item> crudServiceItem;

	// --------------------------------
	// Métodos de la Clase.
	// --------------------------------

	/**
	 * 
	 */
	public RolBO crear(RolBO rolBO) throws SICException {
		Rol rol = new Rol();
		rol.setNombre(rolBO.getNombre());
		rol.setMenu(rolBO.getMenu());
		return this.crudService.create(rol).toBO();
	}

	public RolBO modificar(RolBO rolBO) throws SICException {
		Rol rol = new Rol();
		rol.setIdRol(rolBO.getIdRol());
		rol.setNombre(rolBO.getNombre());
		rol.setMenu(rolBO.getMenu());
		return this.crudService.update(rol).toBO();
	}

	public RolBO buscar(long idRolBO) throws SICException {
		return this.crudService.find(Rol.class, idRolBO).toBO();
	}

	@SuppressWarnings("unchecked")
	public Collection<RolBO> consultarAllRol() throws SICException {
		Collection<RolBO> rolBOs = new ArrayList<RolBO>();
		ArrayList<Rol> rols = (ArrayList<Rol>) this.crudService.findWithNamedQuery("consultarAllRol");
		for (Rol rol : rols)
			rolBOs.add(rol.toBO());
		return rolBOs;
	}

	public ItemBO crear(ItemBO itemBO) throws SICException {
		Item item = new Item();
		item.setTitulo(itemBO.getTitulo());
		item.setOrden(itemBO.getOrden());
		item.setIcono(itemBO.getIcono());
		item.setEsAplicacion(itemBO.isEsAplicacion());
		item.setEstado(itemBO.isEstado());
		item.setModulo(itemBO.getModulo());
		item.setUrlItem(itemBO.getUrl( ) );
		if (itemBO.getItemBOs() != null) {
			Collection<Item> items = new ArrayList<Item>();
			for (ItemBO subItemBO : itemBO.getItemBOs()) {
				Item subItem = new Item();
				subItem.setIdItem(subItemBO.getIdItem( ));
				items.add(subItem);
			}
			item.setItems(items);
		}
		return this.crudServiceItem.create(item).toBO();
	}

	public ItemBO modificar(ItemBO itemBO) throws SICException {
		Item item = new Item();
		item.setIdItem(itemBO.getIdItem( ));
		item.setTitulo(itemBO.getTitulo());
		item.setOrden(itemBO.getOrden());
		item.setIcono(itemBO.getIcono());
		item.setEsAplicacion(itemBO.isEsAplicacion());
		item.setEstado(itemBO.isEstado());
		item.setModulo(itemBO.getModulo());
		item.setUrlItem(itemBO.getUrl( ) );
		if (itemBO.getItemBOs() != null) {
			Collection<Item> items = new ArrayList<Item>();
			for (ItemBO subItemBO : itemBO.getItemBOs()) {
				Item subItem = new Item();
				subItem.setIdItem(subItemBO.getIdItem( ));
				items.add(subItem);
			}
			item.setItems(items);
		}
		return this.crudServiceItem.update(item).toBO();
	}

	@SuppressWarnings("unchecked")
	public Collection<ItemBO> consultarAllItems() throws SICException {
		Collection<ItemBO> itemBOs = new ArrayList<ItemBO>();
		ArrayList<Item> items = (ArrayList<Item>) this.crudServiceItem.findWithNamedQuery("consultarAllItems");
		for (Item item : items)
			itemBOs.add(item.toBO());
		return itemBOs;
	}

}
