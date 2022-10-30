package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/task")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/task/position/{position}")
    public Task getTaskByPosition(@PathVariable("position") long taskPosition) {
        return taskService.getTaskByPosition(taskPosition);
    }

    @DeleteMapping("/task")
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTaskById(@PathVariable("id") long taskId) {
        taskService.deleteTaskById(taskId);
    }

    @PutMapping("/task/{id}")
    public Task updateTaskById(@PathVariable("id") long taskId, @RequestBody Task task) {
        return taskService.updateTaskById(taskId, task);
    }

    @PutMapping("/task/position/{position}")
    public Task updateTaskByPosition(@PathVariable("position") Long taskPosition, @RequestBody Task task) {
        return taskService.updateTaskByPosition(taskPosition, task);
    }

}
