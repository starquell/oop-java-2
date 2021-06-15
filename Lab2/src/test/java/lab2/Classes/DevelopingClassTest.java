package lab2.Classes;

import lab2.entities.Developing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DevelopingClassTest {

    @Test
    void testEmptyGetSet() {
        Developing developing = new Developing();
        Long longTestValue = 55L;
        int hrs = 24;
        boolean active = true;
        developing.setTask_id(longTestValue);
        developing.setEmployee_id(longTestValue);
        developing.setHrs(hrs);
        developing.setActive(active);

        assertEquals(longTestValue, developing.getTask_id());
        assertEquals(longTestValue, developing.getEmployee_id());
        assertEquals(hrs, developing.getHrs());
        assertEquals(active, developing.isActive());
    }

    @Test
    void testToString() {
        Developing developing = new Developing();
        long longTestValue = 55L;
        int hrs = 24;
        boolean active = true;
        developing.setTask_id(longTestValue);
        developing.setEmployee_id(longTestValue);
        developing.setHrs(hrs);
        developing.setActive(active);

        assertEquals(developing.toString(), "Developing{" +
				"employee_id=" + longTestValue +
				", task_id=" + longTestValue +
				", hrs=" + hrs +
				", active=" + active +
				'}');
    }

    @Test
    void testEquals() {
        var d = new Developing();
        long longTestValue = 55L;
        int hrs = 24;
        boolean active = true;
        d.setTask_id(longTestValue);
        d.setEmployee_id(longTestValue);
        d.setHrs(hrs);
        d.setActive(active);

        var d1 = new Developing();
        d1.setTask_id(longTestValue);
        d1.setEmployee_id(longTestValue);
        d1.setHrs(hrs);
        d1.setActive(active);

        assertEquals(d, d1);

        d1.setEmployee_id(5);
        assertNotEquals(d, d1);
    }

    @Test
    void testHashCode() {
        var d = new Developing();
        long longTestValue = 55L;
        int hrs = 24;
        boolean active = true;
        d.setTask_id(longTestValue);
        d.setEmployee_id(longTestValue);
        d.setHrs(hrs);
        d.setActive(active);

        var d1 = new Developing();
        d1.setTask_id(longTestValue);
        d1.setEmployee_id(longTestValue);
        d1.setHrs(hrs);
        d1.setActive(active);

        assertEquals(d.hashCode(), d1.hashCode());

        d1.setEmployee_id(5);
        assertNotEquals(d.hashCode(), d1.hashCode());
    }
}
