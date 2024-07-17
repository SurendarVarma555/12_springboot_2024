package com.usertask.app.repository;

import com.usertask.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findAllByUsers_Id (Long userId);
}
