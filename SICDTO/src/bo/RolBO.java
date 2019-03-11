package bo;

/**
 * SUPERINTENDENCIA DE INDUSTRIA Y COMERCIO.
 * OFICINA DE TECNOLOGÍA E INFORMÁTICA.
 * Proyecto: Sistema de Gestión de Estudios Previos.
 * Autores:
 * 	        Javier Sánchez Muñoz
 * 			Alfonso Rodríguez Suárez
 * Fecha: 03-Nov-2016
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

public class RolBO implements Serializable {

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

	private long idRol;

	private String nombre;

	private byte[] menu;

	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public RolBO() {
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
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

	public void toJson(Collection<ItemBO> itemBOs) {
		JSONArray jsonArrayMenu1 = new JSONArray();
		for (ItemBO itemBO1 : itemBOs) {
			//System.out.println("N1-" + itemBO1.toStringFull());
			JSONObject jsonObjectItemBO1 = new JSONObject();
			jsonObjectItemBO1.put("idItem", itemBO1.getIdItem());
			jsonObjectItemBO1.put("titulo", itemBO1.getTitulo());

			if (itemBO1.getUrlItem() == null)
				jsonObjectItemBO1.put("urlItem", "");
			else
				jsonObjectItemBO1.put("urlItem", itemBO1.getUrlItem());

			//System.out.println("itemBO-urlItem" + itemBO1.getUrlItem());

			jsonObjectItemBO1.put("orden", itemBO1.getOrden());
			jsonObjectItemBO1.put("modulo", itemBO1.getModulo());
			jsonObjectItemBO1.put("icono", itemBO1.getIcono());
			JSONArray jsonArrayMenu2 = new JSONArray();
			System.out.println(itemBO1.getItemBOs().size());
			for (ItemBO itemBO2 : itemBO1.getItemBOs()) {
				if( itemBO2.isEstado( ) ) {
					JSONObject jsonObjectItemBO2 = new JSONObject();
					jsonObjectItemBO2.put("idItem", itemBO2.getIdItem());
					jsonObjectItemBO2.put("titulo", itemBO2.getTitulo());
	
					if (itemBO2.getUrlItem() == null)
						jsonObjectItemBO2.put("urlItem", "");
					else
						jsonObjectItemBO2.put("urlItem", itemBO2.getUrlItem());
	
					//System.out.println("subItemBO-urlItem" + itemBO2.getUrlItem());
	
					jsonObjectItemBO2.put("orden", itemBO2.getOrden());
					jsonObjectItemBO2.put("modulo", itemBO2.getModulo());
					jsonObjectItemBO2.put("icono", itemBO2.getIcono());
					///////////////////////////////////////
	
					JSONArray jsonArrayMenu3 = new JSONArray();
					System.out.println(itemBO2.getItemBOs().size());
					for (ItemBO itemBO3 : itemBO2.getItemBOs()) {
						if( itemBO3.isEstado( ) ) {
							JSONObject jsonObjectItemBO3 = new JSONObject();
							jsonObjectItemBO3.put("idItem", itemBO3.getIdItem());
							jsonObjectItemBO3.put("titulo", itemBO3.getTitulo());
		
							if (itemBO3.getUrlItem() == null)
								jsonObjectItemBO3.put("urlItem", "");
							else
								jsonObjectItemBO3.put("urlItem", itemBO3.getUrlItem());
		
							//System.out.println("subItemBO-urlItem" + itemBO3.getUrlItem());
		
							jsonObjectItemBO3.put("orden", itemBO3.getOrden());
							jsonObjectItemBO3.put("modulo", itemBO3.getModulo());
							jsonObjectItemBO3.put("icono", itemBO3.getIcono());
							System.out.println(itemBO3.getItemBOs().size());
							jsonArrayMenu3.put(jsonObjectItemBO3);
						}
					}
	
					jsonObjectItemBO2.put("subMenu", jsonArrayMenu3);
	
					///////////////////////////////////////
					jsonArrayMenu2.put(jsonObjectItemBO2);
				}
			}
			jsonObjectItemBO1.put("subMenu", jsonArrayMenu2);
			jsonArrayMenu1.put(jsonObjectItemBO1);
		}
		//System.out.println("ENTRA JSON");
		//System.out.println(jsonArrayMenu1.toString());
		//System.out.println("SALE JSON");
		menu = jsonArrayMenu1.toString().getBytes();
	}

	public Collection<ItemBO> toMenu() {
		Collection<ItemBO> itemBOs1 = new ArrayList<ItemBO>();
		JSONArray jsonArrayMenu1 = new JSONArray(new String(menu));
		for (Object object1 : jsonArrayMenu1) {
			JSONObject jsonObjectItemBO1 = (JSONObject) object1;
			ItemBO itemBO1 = new ItemBO();
			itemBO1.setIdItem(jsonObjectItemBO1.getLong("idItem"));
			itemBO1.setTitulo(jsonObjectItemBO1.getString("titulo"));
			itemBO1.setIcono(jsonObjectItemBO1.getString("icono"));
			itemBO1.setOrden(jsonObjectItemBO1.getInt("orden"));
			itemBO1.setModulo(jsonObjectItemBO1.getString("modulo"));
			itemBO1.setUrlItem(jsonObjectItemBO1.getString("urlItem"));
			itemBO1.toURL();
			//System.out.println( itemBO1.toStringFull( ) );
			Collection<ItemBO> itemBOs2 = new ArrayList<ItemBO>();
			if (jsonObjectItemBO1.has("subMenu")) {
				if (jsonObjectItemBO1.getJSONArray("subMenu").length() > 0) {
					for (Object object2 : jsonObjectItemBO1.getJSONArray("subMenu")) {
						JSONObject jsonObjectItemBO2 = (JSONObject) object2;
						ItemBO itemBO2 = new ItemBO();
						itemBO2.setIdItem(jsonObjectItemBO2.getLong("idItem"));
						itemBO2.setTitulo(jsonObjectItemBO2.getString("titulo"));
						itemBO2.setIcono(jsonObjectItemBO2.getString("icono"));
						itemBO2.setOrden(jsonObjectItemBO2.getInt("orden"));
						itemBO2.setModulo(jsonObjectItemBO2.getString("modulo"));
						itemBO2.setUrlItem(jsonObjectItemBO2.getString("urlItem"));
						itemBO2.toURL();
						//System.out.println( itemBO2.toStringFull( ) );
						Collection<ItemBO> itemBOs3 = new ArrayList<ItemBO>();
						if (jsonObjectItemBO2.has("subMenu")) {
							if (jsonObjectItemBO2.getJSONArray("subMenu").length() > 0) {
								for (Object object3 : jsonObjectItemBO2.getJSONArray("subMenu")) {
									JSONObject jsonObjectItemBO3 = (JSONObject) object3;
									ItemBO itemBO3 = new ItemBO();
									itemBO3.setIdItem(jsonObjectItemBO3.getLong("idItem"));
									itemBO3.setTitulo(jsonObjectItemBO3.getString("titulo"));
									itemBO3.setIcono(jsonObjectItemBO3.getString("icono"));
									itemBO3.setOrden(jsonObjectItemBO3.getInt("orden"));
									itemBO3.setModulo(jsonObjectItemBO3.getString("modulo"));
									itemBO3.setUrlItem(jsonObjectItemBO3.getString("urlItem"));
									itemBO3.toURL();
									//System.out.println( itemBO3.toStringFull( ) );
									itemBOs3.add(itemBO3);
								}
							}
						}
						itemBO2.setItemBOs(itemBOs3);
						itemBO2.toHijos( );
						itemBOs2.add(itemBO2);
					}
				}
			}
			itemBO1.setItemBOs(itemBOs2);
			itemBO1.toHijos( );
			itemBOs1.add(itemBO1);
		}
		return itemBOs1;
	}

}
