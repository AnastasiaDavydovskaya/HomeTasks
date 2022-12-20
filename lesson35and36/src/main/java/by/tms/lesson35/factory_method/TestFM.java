package by.tms.lesson35.factory_method;

import by.tms.lesson35.factory_method.factory.BusFactory;
import by.tms.lesson35.factory_method.factory.CarFactory;
import by.tms.lesson35.factory_method.factory.TransportFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestFM {

    public static void main(String[] args) {
        create(new CarFactory());
        create(new BusFactory());
    }

    private static void create(TransportFactory transportFactory) {
        log.info("Transport was created: {}", transportFactory.createTransport());
    }
}
