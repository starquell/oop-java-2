package lab2.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @SequenceGenerator(
            name = "tasks_sequence",
            sequenceName  = "tasks_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tasks_sequence"
    )

    private long id;
	private String name;
	private long project_id;
	private long workers_num;

	public Task(long id, String name, long project_id, long workers_num) {
		this.id = id;
		this.name = name;
		this.project_id = project_id;
		this.workers_num = workers_num;
	}

	public Task(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}

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

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	public long getWorkers_num() {
		return workers_num;
	}

	public void setWorkers_num(long workers_num) {
		this.workers_num = workers_num;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", name='" + name + '\'' +
				", project_id=" + project_id +
				", workers_num=" + workers_num +
				'}';
	}
}
