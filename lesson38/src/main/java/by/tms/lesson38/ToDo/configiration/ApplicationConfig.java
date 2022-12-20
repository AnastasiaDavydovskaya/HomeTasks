package by.tms.lesson38.ToDo.configiration;

import by.tms.lesson38.ToDo.repositories.TaskRepository;
import by.tms.lesson38.ToDo.services.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskRepository taskRepository() {
        return new TaskRepository();
    }

    @Bean
    public TaskService userService() {
        return new TaskService(taskRepository());
    }
}
