package by.tms.lesson31.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Order order = new Order(List.of(new Item("Ваза"), new Item("Кукла")));

        System.out.println(order);
        logger.info(order);
        logger.warn(order);
        logger.error(order);
        logger.debug(order);
    }
}
