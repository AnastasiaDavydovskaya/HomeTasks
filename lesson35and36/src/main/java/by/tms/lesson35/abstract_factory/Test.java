package by.tms.lesson35.abstract_factory;



import by.tms.lesson35.abstract_factory.implfirst.UaPhonePriceAbsFactory;
import by.tms.lesson35.abstract_factory.implsecond.RuPhonePriceAbsFactory;
import by.tms.lesson35.abstract_factory.interfaces.AbsFactory;
import by.tms.lesson35.abstract_factory.interfaces.Apple;
import by.tms.lesson35.abstract_factory.interfaces.Huawei;
import by.tms.lesson35.abstract_factory.interfaces.LG;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {
        AbsFactory factory1 = new UaPhonePriceAbsFactory();
        Apple apple1 = factory1.getApple();
        Huawei huawei1 = factory1.getHuawei();
        LG lg1 = factory1.getLG();
        log.info("Apple from UA = {}", apple1.getApplePrice());
        log.info("Huawei from UA = {}", huawei1.getHuaweiPrice());
        log.info("LG from UA = {}", lg1.getLGPrice());

        AbsFactory factory2 = new RuPhonePriceAbsFactory();
        Apple apple2 = factory2.getApple();
        Huawei huawei2 = factory2.getHuawei();
        LG lg2 = factory2.getLG();
        log.info("Apple from RU = {}", apple2.getApplePrice());
        log.info("Huawei from RU = {}", huawei2.getHuaweiPrice());
        log.info("LG from RU = {}", lg2.getLGPrice());
    }
}
