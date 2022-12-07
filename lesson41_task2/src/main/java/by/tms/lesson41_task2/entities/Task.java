package by.tms.lesson41_task2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @NotEmpty
    @Size(max = 100, message = "Max length can be 100 characters")
    private String description;
    private Status status;
}
