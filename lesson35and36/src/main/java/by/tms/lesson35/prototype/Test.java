package by.tms.lesson35.prototype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {
        MyObject myObject = new MyObject("Ваза");
        MyObject copyMyObject = myObject.copy();

        log.info("Оригинальный объект: {}", myObject);
        log.info("Прототип: {}", copyMyObject);
    }
}
