package lab2.Classes;

import lab2.entities.Employee;
import lab2.entities.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TaskClassTest {
 @Test
    void testEmptyGetSet() {
        Task task = new Task();
        long id = 55L;
        String testName = "Test name";
        int prj = 1;
        int workers = 1;
        task.setId(id);
        task.setName(testName);
        task.setProject_id(prj);
        task.setWorkers_num(workers);

        assertEquals(id, task.getId());
        assertEquals(testName, task.getName());
        assertEquals(prj, task.getProject_id());
        assertEquals(workers, task.getWorkers_num());
    }

    @Test
    void testEquals() {
        Long[] ids = new Long[]{1L, 1L, 3L};
        String[] names = new String[]{"name1", "name1",  "name3"};
        String[] logins = new String[]{"log1", "log1",  "log3"};
        String[] passwords = new String[]{"pass1", "pass1", "pass3"};
        Long[] salaries = new Long[]{1000L, 1000L, 1300L};

        Employee e1 = new Employee();
        e1.setId(ids[0]);
        e1.setName(names[0]);
        e1.setLogin(logins[0]);
        e1.setPassword(passwords[0]);
        e1.setSalary(salaries[0]);

        Employee e2 = new Employee(ids[1], names[1], logins[1], passwords[1], salaries[1]);

        Employee e3 = new Employee(ids[2], names[2], logins[2], passwords[2], salaries[2]);
        assertEquals(e1, e2);
        assertNotEquals(e1, e3);
        assertNotEquals(e2, e3);
        e2.setId(ids[2]);
        e2.setName(names[2]);
        e2.setLogin(logins[2]);
        e2.setPassword(passwords[2]);
        e2.setSalary(salaries[2]);
        assertNotEquals(e1, e2);
        assertNotEquals(e1, e3);
        assertEquals(e2, e3);
    }

    @Test
    void testHashCode() {
        Long[] ids = new Long[]{1L, 1L, 3L};
        String[] names = new String[]{"name1", "name1",  "name3"};
        String[] logins = new String[]{"log1", "log1",  "log3"};
        String[] passwords = new String[]{"pass1", "pass1", "pass3"};
        Long[] salaries = new Long[]{1000L, 1000L, 1300L};

        Employee e1 = new Employee();
        e1.setId(ids[0]);
        e1.setName(names[0]);
        e1.setLogin(logins[0]);
        e1.setPassword(passwords[0]);
        e1.setSalary(salaries[0]);

        Employee e2 = new Employee(ids[1], names[1], logins[1], passwords[1], salaries[1]);

        Employee e3 = new Employee(ids[2], names[2], logins[2], passwords[2], salaries[2]);
        assertEquals(e1.hashCode(), e2.hashCode());
        assertNotEquals(e1.hashCode(), e3.hashCode());
        assertNotEquals(e2.hashCode(), e3.hashCode());
        e2.setId(ids[2]);
        e2.setName(names[2]);
        e2.setLogin(logins[2]);
        e2.setPassword(passwords[2]);
        e2.setSalary(salaries[2]);
        assertNotEquals(e1.hashCode(), e2.hashCode());
        assertNotEquals(e1.hashCode(), e3.hashCode());
        assertEquals(e2.hashCode(), e3.hashCode());
    }

}
