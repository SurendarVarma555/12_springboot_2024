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

    /*Save Task Individual Task Api
     * http://localhost:9090/api/{userId}/tasks
     * */
    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TaskDto> saveTask (@PathVariable(name = "userId") Long userId, @RequestBody TaskDto taskDto){
        TaskDto savedTaskDto = taskService.saveTask(userId, taskDto);
        return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
    }

    /*Get Individual Task Api
    * http://localhost:9090/api/{userId}/tasks
    * */
    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks (@PathVariable(name = "userId") Long userId){
        return new ResponseEntity<>(taskService.getAllTasks(userId), HttpStatus.OK);
    }

    /*Get Individual Task
     * http://localhost:9090/api/{userId}/tasks/{taskId}
     * */
    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTask (@PathVariable(name = "userId") Long userId,
                                            @PathVariable(name = "taskId") Long taskId
    ){
        return new ResponseEntity<>(taskService.getTask(userId, taskId), HttpStatus.OK);

    }

    /*DELETE API
    * http://localhost:9090/api//{userId}/tasks/{taskId}
    * */

    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask (@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "taskId") Long taskId
    ){
        taskService.deleteTask(userId, taskId);
        return new ResponseEntity<>("Task deleted Successfully", HttpStatus.OK);

    }

}
