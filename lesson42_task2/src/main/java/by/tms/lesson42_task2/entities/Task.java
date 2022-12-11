package by.tms.lesson42_task2.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Long id;
    @NotEmpty
    @Size(max = 100, message = "Max length can be 100 characters")
    private String description;
    private Status status;
}
