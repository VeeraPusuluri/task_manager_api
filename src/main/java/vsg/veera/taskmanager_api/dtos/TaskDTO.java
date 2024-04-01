package vsg.veera.taskmanager_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDTO {
    String title;
    String desc;
    String deadline;
}
