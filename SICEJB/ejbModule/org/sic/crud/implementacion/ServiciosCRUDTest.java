package org.sic.crud.implementacion;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.sic.crud.interfaz.IServiciosCRUDTest;
import org.sic.entities.Test;
import org.sic.exceptions.SICException;
import org.sic.persistence.jpa.CRUDService;

import bo.TestBO;


@Stateless
public class ServiciosCRUDTest implements IServiciosCRUDTest {

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	/**
	 * Servicios CRUD para las cuentas.
	 */
	@EJB
	private CRUDService<Test> crudService;

	// --------------------------------
	// Métodos de la Clase.
	// --------------------------------

	public TestBO crear(TestBO testBO) throws SICException {

		Test test = new Test();
		test.setDescripcion(testBO.getDescripcion());
		test.setCodigo(testBO.getCodigo());

		return crudService.create(test).toBO();
	}

	public TestBO modificar(TestBO testBO) throws SICException {

		Test test = new Test();
		test.setIdTest(testBO.getIdTest( ) );
		test.setDescripcion(testBO.getDescripcion());
		test.setCodigo(testBO.getCodigo());

		return crudService.update(test).toBO();
	}

	public TestBO buscar(long idTestBO) throws SICException {
		return this.crudService.find(Test.class, idTestBO).toBO();
	}

	@SuppressWarnings("unchecked")
	public Collection<TestBO> consultarAllTest() throws SICException {
		Collection<TestBO> testBOs = new ArrayList<TestBO>();
		ArrayList<Test> tests = (ArrayList<Test>) this.crudService.findWithNamedQuery("consultarAllTest");
		for (Test test : tests)
			testBOs.add(test.toBO());
		return testBOs;

	}

}
