package com.itninja.simplecrudpgjdk21.domain.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itninja.simplecrudpgjdk21.domain.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
