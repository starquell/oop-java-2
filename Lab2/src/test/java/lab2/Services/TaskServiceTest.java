package lab2.Services;


import lab2.entities.Task;
import lab2.repositories.TaskRepository;
import lab2.services.TaskService;
import org.junit.jupiter.api.Assertions;
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
public class TaskServiceTest {

    @Autowired
    private TaskService service;

    @MockBean
    private TaskRepository repository;

    @Test
    void testGetAll() {
        var task = new Task(5, "Pass this test", 0, 0);
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task);
        doReturn(taskList).when(repository).findAll();
        List<Task> returnedWidget = service.GetTasks();
        assertEquals(returnedWidget.size(), 1);
    }

    @Test
    void testById(){
        var task = new Task(5, "Pass this test", 0, 0);
        doReturn(Optional.of(task)).when(repository).findById(5L);
        var foundTask = service.GetTaskById(5L);
        Assertions.assertEquals(task, foundTask);
    }

    @Test
    void testUpdate() {
        var task = new Task(5, "Pass this test", 0, 0);
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task);
        doReturn(taskList).when(repository).findAll();
        doReturn(Optional.of(task)).when(repository).findById(5L);

        service.updateTask(5L, new Task(5, "Pass this test other way", 0, 0));
        List<Task> returnedWidget = service.GetTasks();
        assertEquals(returnedWidget.get(0).getName(), "Pass this test other way");
    }

    @Test
    void testAdd() {
        var task = new Task(5, "Pass this test", 0, 0);
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task);
        doReturn(taskList).when(repository).findAll();
        service.addNewTask(new Task(3, "Pass this test other way", 0, 0));
        List<Task> returnedWidget = service.GetTasks();
        assertEquals(returnedWidget.get(0).getName(), "Pass this test");
    }

    @Test
    void testDelete() {
        var task = new Task(5, "Pass this test", 0, 0);
        ArrayList<Task> employeeList = new ArrayList<>();
        employeeList.add(task);
        doReturn(employeeList).when(repository).findAll();
        doReturn(true).when(repository).existsById(3L);
        service.deleteTask(3L);
        List<Task> returnedWidget = service.GetTasks();
        assertEquals(returnedWidget.size(), 1);
    }
}
