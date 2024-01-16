package com.itninja.simplecrudpgjdk21.domain.task.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.itninja.simplecrudpgjdk21.domain.task.entity.Task;
import com.itninja.simplecrudpgjdk21.domain.task.mapper.TaskMapper;
import com.itninja.simplecrudpgjdk21.domain.task.model.TaskDto;
import com.itninja.simplecrudpgjdk21.domain.task.repository.TaskRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public TaskDto createTask(TaskDto taskDto) {
        Task newEntity = TaskMapper.toCreateEntity(taskDto);
        taskRepository.saveAndFlush(newEntity);
        return TaskMapper.toDto(newEntity);
    }

    @Transactional
    public TaskDto updateTask(TaskDto taskDto) {
        return Optional.ofNullable(taskDto.id())
                .flatMap(taskRepository::findById)
                .map(task -> updateTask(task, taskDto))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    public TaskDto updateTask(Task task, TaskDto taskDto) {
        TaskMapper.updateEntity(task, taskDto);
        taskRepository.saveAndFlush(task);
        return TaskMapper.toDto(task);
    }

    public TaskDto getTask(Long taskId) {
        return Optional.ofNullable(taskId)
                .flatMap(taskRepository::findById)
                .map(TaskMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    public void deleteTask(Long taskId) {
        Optional.ofNullable(taskId)
                .flatMap(taskRepository::findById)
                .ifPresentOrElse(taskRepository::delete, () -> {
                    throw new ResponseStatusException(NOT_FOUND);
                });
    }
}
