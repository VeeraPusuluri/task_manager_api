package vsg.veera.taskmanager_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.FixedDelayTask;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import vsg.veera.taskmanager_api.dtos.ErrorResponseDto;
import vsg.veera.taskmanager_api.dtos.TaskDTO;
import vsg.veera.taskmanager_api.dtos.UpdateTaskDTO;
import vsg.veera.taskmanager_api.entities.TaskEntity;
import vsg.veera.taskmanager_api.service.TaskService;

import java.net.http.HttpResponse;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;

    int taskId = 1;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("")
    ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) throws ParseException {
        TaskEntity taskEntity = new TaskEntity(taskId, taskDTO.getTitle(), taskDTO.getDesc(), taskDTO.getDeadline(), false);
        taskId++;
        taskService.addTask(taskEntity);
        return ResponseEntity.ok(taskDTO);
    }


    @GetMapping("")
    ResponseEntity<List<TaskEntity>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    ResponseEntity<List<TaskEntity>> getTaskById(@PathVariable("id") int id) {
        List<TaskEntity> taskEntity = taskService.getTaskById(id);
        if (taskEntity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskEntity);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTaskById(@PathVariable("id") int id, @RequestBody UpdateTaskDTO taskDTO){
        if (taskDTO == null){
            return ResponseEntity.badRequest().build();
        }
        TaskEntity updatedTaskEntity = taskService.updateTaskById(id,taskDTO);
        return ResponseEntity.ok(updatedTaskEntity);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e){
        if (e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDto("Invalid Date format"));
        }
        e.printStackTrace();
        return ResponseEntity.badRequest().body(new ErrorResponseDto("Invalid Request"));
    }



}
