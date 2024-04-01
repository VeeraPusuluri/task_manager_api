package vsg.veera.taskmanager_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Setter
@Getter
@AllArgsConstructor
public class TaskEntity {
    private int id;
    public String title;
    public String description;
    public String deadline;
    public boolean completed;



}
