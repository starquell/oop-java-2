package lab2.services;


import lab2.entities.Task;
import lab2.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public List<Task> GetTasks(){
        return repository.findAll();
    }

    public Task GetTaskById(Long taskId){
        Optional<Task> task= repository.findById(taskId);
        if (task.isEmpty()) {
            throw new IllegalStateException("No task with id = " + taskId);
        }
        return task.get();
    }

    public void addNewTask(Task task){
        var taskById = repository.findTaskById(task.getId());
        if (taskById.isPresent()) {
            throw new IllegalStateException("Task with id = " + task.getId() + " already exists");
        }
        repository.save(task);
    }

    public void deleteTask(Long taskId) {
        if(repository.existsById(taskId)){
            repository.deleteById(taskId);
        } else {
            throw new IllegalStateException("Task with id = " + taskId + " doesn't exist.");
        }
    }

    public void updateTask(Long taskId, Task newTask){
        Task task = repository.findById(taskId).orElseThrow(() -> new IllegalStateException(
                "Task with id = " + taskId + " doesn't exist"
        ));
        task.setName(newTask.getName());
        task.setProject_id(newTask.getProject_id());
        task.setWorkers_num(newTask.getWorkers_num());
        repository.save(task);
    }
}
