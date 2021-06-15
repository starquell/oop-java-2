package lab2.services;

import lab2.entities.Employee;
import lab2.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public List<Employee> GetEmployees(){
        return repository.findAll();
    }

    public Employee GetEmployeeById(Long employeeId){
        Optional<Employee> employee = repository.findById(employeeId);
        if (employee.isEmpty()){
            throw new IllegalStateException("No employee with id = " + employeeId);
        }
        return employee.get();
    }

    public void addNewEmployee(Employee employee){
        var employeeById = repository.findEmployeeById(employee.getId());
        if (employeeById.isPresent()){
            throw new IllegalStateException("Employee with id = " + employee.getId() + " already exists");
        }
        repository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        if (repository.existsById(employeeId)){
            repository.deleteById(employeeId);
        } else {
            throw new IllegalStateException("Employee with id = " + employeeId + " doesn't exist.");
        }
    }

    public void updateEmployee(Long employeeId, Employee newEmployee){
        Employee employee = repository.findById(employeeId).orElseThrow(() -> new IllegalStateException(
                "Employee with id = " + employeeId + " doesn't exist"
        ));

        employee.setName(newEmployee.getName());
        employee.setLogin(newEmployee.getLogin());
        employee.setPassword(newEmployee.getPassword());
        employee.setSalary(newEmployee.getSalary());
        repository.save(employee);
    }
}
