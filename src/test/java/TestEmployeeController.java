import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Test;

import com.nt.controller.EmployeeController;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.entity.Employee;

import junit.framework.TestCase;

public class TestEmployeeController extends TestCase {
	EmployeeController controller;
	EmployeeDAO employeeDAOImpl;
	Mockery context;

	protected void setUp() throws Exception {
		context = new Mockery();
		controller = new EmployeeController();
		employeeDAOImpl = new EmployeeDAOImpl();
		controller.setDao(employeeDAOImpl);
	}

	protected void tearDown() throws Exception {
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
