package vsg.veera.taskmanager_api.service;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import vsg.veera.taskmanager_api.entities.TaskEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final ArrayList<TaskEntity> tasks = new ArrayList<TaskEntity>();
    private final int taskId = 1;


    public void addTask(TaskEntity task) {
        tasks.add(task);
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public List<TaskEntity> getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).toList();
    }

}
