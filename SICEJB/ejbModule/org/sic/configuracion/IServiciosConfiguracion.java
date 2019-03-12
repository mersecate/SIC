/**
 * Geoplaneación SAS.
 * Autor: Alfonso Rodríguez Suárez, MsC.
 * Fecha: 31-Oct-2015
 */
package org.sic.configuracion;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ejb.Local;

import org.sic.exceptions.SICException;

/**
 * @author ALFONSO
 *
 */

@Local
public interface IServiciosConfiguracion {

	/**
	 * 
	 * @throws SICException
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public void instalacion() throws SICException, IOException;

}
