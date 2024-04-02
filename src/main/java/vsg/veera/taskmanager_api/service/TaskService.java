package vsg.veera.taskmanager_api.service;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import vsg.veera.taskmanager_api.dtos.UpdateTaskDTO;
import vsg.veera.taskmanager_api.entities.TaskEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final ArrayList<TaskEntity> tasks = new ArrayList<TaskEntity>();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final int taskId = 1;


    public void addTask(TaskEntity task) throws ParseException {
        simpleDateFormat.parse(task.getDeadline());
        tasks.add(task);
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public List<TaskEntity> getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).toList();
    }

    public TaskEntity updateTaskById(int id, UpdateTaskDTO taskEntity){
         TaskEntity task = getTaskById(id).getFirst();
         task.setDescription(taskEntity.getDesc());
         task.setDeadline(taskEntity.getDeadline());
         task.setCompleted(taskEntity.getCompleted());
         return task;
    }

}
