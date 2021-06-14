package entities;

import org.junit.Assert;
import org.junit.Test;

import entities.Employee;
import entities.Role;

public class EmployeeTest {
	@Test
	public void testGettersSetters(){
		Employee emp = new Employee();
		emp.setId((long) 1);
		Assert.assertEquals((long)1,emp.getId());
		
		emp.setName("Anna");
		Assert.assertEquals("Anna",emp.getName());
		
		emp.setLogin("anna");
		Assert.assertEquals("anna",emp.getLogin());
		
		emp.setPassword("password");
		Assert.assertEquals("password",emp.getPassword());
		
		emp.setSalary((long) 25);
		Assert.assertEquals((long)25,emp.getSalary());
	}

}
