package lab2.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
    @SequenceGenerator(
            name = "employees_sequence",
            sequenceName  = "employees_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employees_sequence"
    )
    private long id;
	private String name;
	private String login;
	private String password;
	private long salary;

    public Employee(long id, String name, String login, String password, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.salary = salary;
	}

	public Employee() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", salary=" + salary +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return id == employee.id && salary == employee.salary && Objects.equals(name, employee.name) && login.equals(employee.login) && Objects.equals(password, employee.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, login, password, salary);
	}

}
