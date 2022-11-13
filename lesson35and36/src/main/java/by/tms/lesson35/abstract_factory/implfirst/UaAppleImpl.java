package by.tms.lesson35.abstract_factory.implfirst;

import by.tms.lesson35.abstract_factory.interfaces.Apple;

public class UaAppleImpl implements Apple {

    @Override
    public Long getApplePrice() {
        return 3000L;
    }
}
