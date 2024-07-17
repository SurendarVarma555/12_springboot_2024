package com.usertask.app.controller;

import com.usertask.app.playload.TaskDto;
import com.usertask.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Save the Task
    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TaskDto> saveTask (@PathVariable(name = "userId") Long userId, @RequestBody TaskDto taskDto){
        TaskDto savedTaskDto = taskService.saveTask(userId, taskDto);
        return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
    }


}
