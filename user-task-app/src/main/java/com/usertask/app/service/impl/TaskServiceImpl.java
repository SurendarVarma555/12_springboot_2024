package com.usertask.app.service.impl;

import com.usertask.app.entity.Task;
import com.usertask.app.entity.Users;
import com.usertask.app.exception.UserNotFound;
import com.usertask.app.playload.TaskDto;
import com.usertask.app.repository.TaskRepo;
import com.usertask.app.repository.UserRepo;
import com.usertask.app.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return null;
    }
}

