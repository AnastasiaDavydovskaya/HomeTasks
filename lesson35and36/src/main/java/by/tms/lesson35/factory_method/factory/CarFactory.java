package by.tms.lesson35.factory_method.factory;


import by.tms.lesson35.factory_method.entities.Car;
import by.tms.lesson35.factory_method.entities.Transport;

public class CarFactory extends TransportFactory {

    @Override
    public Transport createTransport() {
        return new Car();
    }
}
