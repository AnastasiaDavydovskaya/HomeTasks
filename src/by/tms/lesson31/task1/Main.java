package by.tms.lesson31.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Order order1 = new Order();
        Item item1 = new Item("Ваза");
        Item item2 = new Item();

        logger.info("Create order={}", order1);
        logger.info("Create item={}", item1);
        logger.warn("Add item in order={}", order1.addItems(item1));
        logger.error("Add empty item in order={}", order1.addItems(item2));
        logger.debug("Describe information about order={}", order1.toString());
    }
}
