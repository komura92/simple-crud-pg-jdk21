package com.itninja.simplecrudpgjdk21.domain.task.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import com.itninja.simplecrudpgjdk21.domain.task.entity.Task;
import com.itninja.simplecrudpgjdk21.domain.task.model.TaskDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskMapper {

    public static TaskDto toDto(Task task) {
        return new TaskDto(task.getId());
    }

    public static Task toCreateEntity(TaskDto taskDto) {
        return Task.builder()
                // create mapping
                .build();
    }

    public static void updateEntity(Task task, TaskDto taskDto) {
        // update entity
    }
}
