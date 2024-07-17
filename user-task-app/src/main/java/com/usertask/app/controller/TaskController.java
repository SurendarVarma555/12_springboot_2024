package com.usertask.app.controller;

import com.usertask.app.playload.TaskDto;
import com.usertask.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks (@PathVariable(name = "userId") Long userId){
        return new ResponseEntity<>(taskService.getAllTasks(userId), HttpStatus.OK);
    }

    /*Get Individual Task
    * http://localhost:9090/api/1/tasks/3
    * */
    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTask (@PathVariable(name = "userId") Long userId,
                                            @PathVariable(name = "taskId") Long taskId
    ){
        return new ResponseEntity<>(taskService.getTask(userId, taskId), HttpStatus.OK);

    }

}
