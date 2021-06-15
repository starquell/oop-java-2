package lab2.Services;


import lab2.entities.Employee;
import lab2.repositories.EmployeeRepository;
import lab2.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @MockBean
    private EmployeeRepository repository;


    @Test
    void testGetAll() {
        Employee employee = new Employee(3, "Me", "login", "pass", 2400);
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        doReturn(employeeList).when(repository).findAll();
        List<Employee> returnedWidget = service.GetEmployees();
        assertEquals(returnedWidget.size(), 1);
    }

    @Test
    void testById(){
        Employee employee = new Employee(3, "Me", "login", "pass", 2400);
        doReturn(Optional.of(employee)).when(repository).findById(0L);
        Employee foundEmployee = service.GetEmployeeById(0L);
        assertEquals(employee, foundEmployee);
    }

    @Test
    void testUpdate() {
        Employee employee = new Employee(3, "Me", "login", "pass", 2400);
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        doReturn(employeeList).when(repository).findAll();
        doReturn(Optional.of(employee)).when(repository).findById(3L);

        service.updateEmployee(3L, new Employee(3, "Me-Not-Me", "login", "pass", 2400));
        List<Employee> returnedWidget = service.GetEmployees();
        assertEquals(returnedWidget.get(0).getName(), "Me-Not-Me");
    }

    @Test
    void testAdd() {
        Employee employee = new Employee(3, "Me", "login", "pass", 2400);
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        doReturn(employeeList).when(repository).findAll();
        service.addNewEmployee(new Employee(3, "Not me", "login", "pass", 2400));
        List<Employee> returnedWidget = service.GetEmployees();
        assertEquals(returnedWidget.get(0).getName(), "Me");
    }

    @Test
    void testDelete() {
        Employee employee = new Employee(3, "Me", "login", "pass", 2400);
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        doReturn(employeeList).when(repository).findAll();
        doReturn(true).when(repository).existsById(3L);
        service.deleteEmployee(3L);
        List<Employee> returnedWidget = service.GetEmployees();
        assertEquals(returnedWidget.size(), 1);
    }
}
