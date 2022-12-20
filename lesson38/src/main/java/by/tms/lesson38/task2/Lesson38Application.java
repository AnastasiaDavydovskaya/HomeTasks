package by.tms.lesson38.task2;

import by.tms.lesson38.task2.entities.User;
import by.tms.lesson38.task2.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Lesson38Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.tms.lesson38.task2");
        UserService userService = applicationContext.getBean(UserService.class);

        for(User user: userService.getUsers()) {
            log.info("User info: {}, {}", user.getLogin(), user.getPassword());
        }
    }

}
