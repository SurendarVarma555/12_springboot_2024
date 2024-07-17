package com.usertask.app.service.impl;

import com.usertask.app.entity.Task;
import com.usertask.app.entity.Users;
import com.usertask.app.exception.ApiException;
import com.usertask.app.exception.TaskNotFound;
import com.usertask.app.exception.UserNotFound;
import com.usertask.app.playload.TaskDto;
import com.usertask.app.repository.TaskRepo;
import com.usertask.app.repository.UserRepo;
import com.usertask.app.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TaskDto saveTask (long userId, TaskDto taskDto){
        Users user = userRepo.findById(userId).orElseThrow(() -> new UserNotFound(String.format("User not found with given Id %d", userId)));
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(user);
        Task savedTask = taskRepo.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks (Long userId){
        userRepo.findById(userId).orElseThrow(() -> new UserNotFound(String.format("user not found with id %d", userId)));
        List<Task> tasks = taskRepo.findAllByUsers_Id(userId);
        return tasks.stream().map(task -> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());

    }

    @Override
    public TaskDto getTask (Long userId, Long taskId){
        Users user = userRepo.findById(userId).orElseThrow(() -> new UserNotFound(String.format("user not found with id %d", userId)));
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new TaskNotFound(String.format("Task not found with id %d", taskId)));
        if (user.getId() != task.getUsers().getId()) {
            throw new ApiException(String.format("Task id %d is not belongs to User Id %d", taskId, userId));
        }
        return modelMapper.map(task, TaskDto.class);
    }
}

