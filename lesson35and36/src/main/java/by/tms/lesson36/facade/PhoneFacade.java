package by.tms.lesson36.facade;

public class PhoneFacade {

    private Phone phone;

    public PhoneFacade(Phone phone) {
        this.phone = phone;
    }

    public void turnOn() {
        phone.makeBrightness();
        phone.makeSound();
        phone.openApps();
    }

    public void turnOff() {
        phone.stopBrightness();
        phone.disableSound();
        phone.closeApps();
    }
}
