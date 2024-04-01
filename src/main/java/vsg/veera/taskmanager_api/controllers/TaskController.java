package vsg.veera.taskmanager_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsg.veera.taskmanager_api.dtos.TaskDTO;
import vsg.veera.taskmanager_api.entities.TaskEntity;
import vsg.veera.taskmanager_api.service.TaskService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController()
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("")
    ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        TaskEntity taskEntity = new TaskEntity(1, taskDTO.getTitle(), taskDTO.getDesc(), taskDTO.getDeadline(), false);
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

}
