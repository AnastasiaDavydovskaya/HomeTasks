package by.tms.lesson35.abstract_factory.implsecond;


import by.tms.lesson35.abstract_factory.interfaces.AbsFactory;
import by.tms.lesson35.abstract_factory.interfaces.Apple;
import by.tms.lesson35.abstract_factory.interfaces.Huawei;
import by.tms.lesson35.abstract_factory.interfaces.LG;

public class RuPhonePriceAbsFactory implements AbsFactory {

    @Override
    public Apple getApple() {
        return new RuAppleImpl();
    }

    @Override
    public LG getLG() {
        return new RuLGImpl();
    }

    @Override
    public Huawei getHuawei() {
        return new RuHuaweiImpl();
    }
}
