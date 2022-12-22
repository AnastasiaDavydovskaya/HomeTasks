package by.tms.lesson45_task2.entities;

import by.tms.lesson45_task2.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(max = 10, message = "Максимальная длина может быть 10 символов")
    private String description;
    private Status status;
}
