package by.tms.lesson39.ToDo;

import by.tms.lesson39.ToDo.entities.Task;
import by.tms.lesson39.ToDo.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class Lesson38Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.tms.lesson39.ToDo");

        TaskService taskService = applicationContext.getBean(TaskService.class);

        taskService.addTask("Убраться");
        taskService.addTask("Сделать дз");
        taskService.addTask("Поспать");

        List<Task> tasks = taskService.getTasks();

        taskService.changeStatusOfTask(tasks.get(1));
        taskService.deleteTask(tasks.get(1));
    }

}
