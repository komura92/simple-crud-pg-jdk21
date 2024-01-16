package com.itninja.simplecrudpgjdk21.domain.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itninja.simplecrudpgjdk21.domain.task.model.TaskDto;
import com.itninja.simplecrudpgjdk21.domain.task.service.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping(TaskController.PATH)
public class TaskController {
    public static final String PATH = "/task";

    private final TaskService taskService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskService.updateTask(taskDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDto getTask(@RequestParam Long taskId) {
        return taskService.getTask(taskId);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam Long taskId) {
        taskService.deleteTask(taskId);
    }
}
