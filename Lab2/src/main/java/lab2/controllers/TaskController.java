package lab2.controllers;

import lab2.services.TaskService;
import lab2.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> GetTasks(){
        return taskService.GetTasks();
    }

    @GetMapping(path="{taskId}")
    public Task GetTaskById(@PathVariable("taskId") Long taskId){
        return taskService.GetTaskById(taskId);
    }

    @PostMapping
    public void registerNewtask(@RequestBody Task task, @RequestHeader("Authorization") String authString){
        taskService.addNewTask(task);
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path="{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestBody Task task){
        taskService.updateTask(taskId, task);
    }
}
