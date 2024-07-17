package com.usertask.app.service.impl;

import com.usertask.app.entity.Task;
import com.usertask.app.entity.Users;
import com.usertask.app.playload.TaskDto;
import com.usertask.app.repository.TaskRepo;
import com.usertask.app.repository.UserRepo;
import com.usertask.app.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return null;
    }

    @Override
    public List<TaskDto> getAllTasks (Long userId){
        return null;
    }
}

