package com.example.demo.service;

import com.example.demo.model.Task;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task saveTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(long taskId);

    Task getTaskByPosition(Long taskPosition);

    void deleteAllTasks();

    void deleteTaskById(long taskId);

    Task updateTaskById(long taskId, Task task);

    Task updateTaskByPosition(Long taskPosition, Task task);

}
