package by.tms.lesson36.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Phone {

    public void makeSound() {
        log.info("Звук включен");
    }

    public void openApps() {
        log.info("Приложения доступны");
    }

    public void makeBrightness() {
        log.info("Яркость настроена");
    }

    public void disableSound() {
        log.info("Звук выключен");
    }

    public void closeApps() {
        log.info("Приложения закрыты");
    }

    public void stopBrightness() {
        log.info("Яркость вылючена");
    }

}
