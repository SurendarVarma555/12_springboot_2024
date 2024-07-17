package com.usertask.app.service;

import com.usertask.app.playload.TaskDto;

import java.util.List;

public interface TaskService {

    public TaskDto saveTask (long userId, TaskDto taskDto);

    public List<TaskDto> getAllTasks (Long userId);

    public TaskDto getTask (Long userId, Long taskId);
}
