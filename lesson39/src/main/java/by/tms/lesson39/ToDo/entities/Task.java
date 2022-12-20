package by.tms.lesson39.ToDo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Task {

    private String description;
    private Status status;
}
