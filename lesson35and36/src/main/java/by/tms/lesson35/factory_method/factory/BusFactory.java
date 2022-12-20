package by.tms.lesson35.factory_method.factory;


import by.tms.lesson35.factory_method.entities.Bus;
import by.tms.lesson35.factory_method.entities.Transport;

public class BusFactory extends TransportFactory {

    @Override
    public Transport createTransport() {
        return new Bus();
    }
}
