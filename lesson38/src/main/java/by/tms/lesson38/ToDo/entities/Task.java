package by.tms.lesson38.ToDo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {

    private String description;
    private Status status;
}
