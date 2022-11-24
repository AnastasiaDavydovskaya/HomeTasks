package by.tms.lesson38.task1;

import by.tms.lesson38.task1.entities.User;
import by.tms.lesson38.task1.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Lesson38Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        for(User user: userService.getUsers()) {
            log.info("User info: {}, {}", user.getLogin(), user.getPassword());
        }
    }

}
