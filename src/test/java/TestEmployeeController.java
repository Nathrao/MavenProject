import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.nt.controller.EmployeeController;
import com.nt.dao.EmployeeDAO;
import com.nt.entity.Employee;

public class TestEmployeeController {
	EmployeeController	controller;
	EmployeeDAO			employeeDAOImpl;

	@Before
	public void setUp() throws Exception {
		controller = new EmployeeController();
		employeeDAOImpl = Mockito.mock(EmployeeDAO.class);
		controller.setDao(employeeDAOImpl);
	}

	@After
	public void tearDown() throws Exception {
		controller = null;
	}

	@Test
	public void testSaveEmployee() {

		Employee employee = new Employee();
		employee.setEmpId(123);
		employee.setEmpName("Ram");
		employee.setSalary(102020);
		String result = controller.saveEmployee(employee);
		Assert.assertEquals("Registration Successful", result);
	}
}
