package by.tms.lesson35.abstract_factory.implsecond;


import by.tms.lesson35.abstract_factory.interfaces.Apple;

public class RuAppleImpl implements Apple {

    @Override
    public Long getApplePrice() {
        return 30000L;
    }
}
