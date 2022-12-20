package by.tms.lesson35.abstract_factory.implfirst;


import by.tms.lesson35.abstract_factory.interfaces.AbsFactory;
import by.tms.lesson35.abstract_factory.interfaces.Apple;
import by.tms.lesson35.abstract_factory.interfaces.Huawei;
import by.tms.lesson35.abstract_factory.interfaces.LG;

public class UaPhonePriceAbsFactory implements AbsFactory {

    @Override
    public Apple getApple() {
        return new UaAppleImpl();
    }

    @Override
    public LG getLG() {
        return new UaLGImpl();
    }

    @Override
    public Huawei getHuawei() {
        return new UaHuaweiImpl();
    }
}
