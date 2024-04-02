package vsg.veera.taskmanager_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateTaskDTO {

    String desc;
    String deadline;
    Boolean completed;
}
