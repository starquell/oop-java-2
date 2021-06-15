package lab2.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "developing")
public class Developing {
    @Id
    @SequenceGenerator(
            name = "developing_sequence",
            sequenceName  = "developing_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "developing_sequence"
    )

    private long employee_id;
	private long task_id;
	private long hrs;
	private boolean active;

    public Developing() {
    }
    public Developing(long employee_id, long task_id, long hrs, boolean active) {
		super();
		this.employee_id = employee_id;
		this.task_id = task_id;
		this.hrs = hrs;
		this.active = active;
	}
	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long emplyee_id) {
		this.employee_id = emplyee_id;
	}
	public long getTask_id() {
		return task_id;
	}
	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}
	public long getHrs() {
		return hrs;
	}
	public void setHrs(long hrs) {
		this.hrs = hrs;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Developing that = (Developing) o;
		return employee_id == that.employee_id && task_id == that.task_id && hrs == that.hrs && active == that.active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee_id, task_id, hrs, active);
	}

	@Override
	public String toString() {
		return "Developing{" +
				"employee_id=" + employee_id +
				", task_id=" + task_id +
				", hrs=" + hrs +
				", active=" + active +
				'}';
	}
}
