package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        task.setTaskPosition(taskRepository.count() + 1);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public Task getTaskByPosition(Long taskPosition) {
        return taskRepository.findByTaskPosition(taskPosition);
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public void deleteTaskById(long taskId) {
        taskRepository.deleteById(taskId);
        List<Task> tasks = taskRepository.getTasksGreaterThanGivenPosition(taskId);
        for(Task task: tasks) {
            task.setTaskPosition(task.getTaskPosition() - 1);
            taskRepository.save(task);
        }
    }

    @Override
    public Task updateTaskById(long taskId, Task task) {
        Task taskToUpdate = taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getTaskTitle()) && !"".equalsIgnoreCase(task.getTaskTitle())){
            taskToUpdate.setTaskTitle(task.getTaskTitle());
        }
        if(Objects.nonNull(task.getTaskContent()) && !"".equalsIgnoreCase(task.getTaskContent())) {
            taskToUpdate.setTaskContent(task.getTaskContent());
        }
        if(Objects.nonNull(task.getTaskPosition()) && task.getTaskPosition() <= taskRepository.count()) {
            Task taskToSwap = taskRepository.findByTaskPosition(task.getTaskPosition());
            taskToSwap.setTaskPosition(taskToUpdate.getTaskPosition());
            taskRepository.save(taskToSwap);
            taskToUpdate.setTaskPosition(task.getTaskPosition());
        }
        return taskRepository.save(taskToUpdate);
    }

    @Override
    public Task updateTaskByPosition(Long taskPosition, Task task) {
        Task taskToUpdate = taskRepository.findByTaskPosition(taskPosition);

        if(Objects.nonNull(task.getTaskTitle()) && !"".equalsIgnoreCase(task.getTaskTitle())){
            taskToUpdate.setTaskTitle(task.getTaskTitle());
        }
        if(Objects.nonNull(task.getTaskContent()) && !"".equalsIgnoreCase(task.getTaskContent())) {
            taskToUpdate.setTaskContent(task.getTaskContent());
        }
        if(Objects.nonNull(task.getTaskPosition()) && task.getTaskPosition() <= taskRepository.count()) {
            Task taskToSwap = taskRepository.findByTaskPosition(task.getTaskPosition());
            taskToSwap.setTaskPosition(taskToUpdate.getTaskPosition());
            taskRepository.save(taskToSwap);
            taskToUpdate.setTaskPosition(task.getTaskPosition());
        }
        return taskRepository.save(taskToUpdate);
    }

}
