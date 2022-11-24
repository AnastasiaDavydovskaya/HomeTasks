package by.tms.lesson38.ToDo;

import by.tms.lesson38.ToDo.configiration.ApplicationConfig;
import by.tms.lesson38.ToDo.entities.Task;
import by.tms.lesson38.ToDo.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Lesson38Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        TaskService taskService = applicationContext.getBean(TaskService.class);

        taskService.addTask("Задание 1");
        taskService.addTask("Задание 2");
        taskService.addTask("Задание 3");

        for (Task task : taskService.getTasks()) {
            log.info("Task: {}, {}", task.getDescription(), task.getStatus());
        }

        for (Task task : taskService.getTasks()) {
            taskService.changeStatusOfTask(task);
            log.info("Task changed status: {}, {}", task.getDescription(), task.getStatus());
        }

        for (Task task : taskService.getTasks()) {
            taskService.deleteTask(task);
            log.info("Task changed status: {}, {}", task.getDescription(), task.getStatus());
        }
    }

}
