package by.tms.lesson49.mapper;

import by.tms.lesson49.dto.TaskDto;
import by.tms.lesson49.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "status", constant = "TO_DO")
    Task toTask(TaskDto taskDto);
    TaskDto toTaskDto(Task task);
}
