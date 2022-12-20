package by.tms.lesson39.task1;

import by.tms.lesson39.task1.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Lesson38Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.tms.lesson39.task1");

        UserService userService = applicationContext.getBean(UserService.class);
        log.info("Found: {}", userService.getUsers());
    }

}
