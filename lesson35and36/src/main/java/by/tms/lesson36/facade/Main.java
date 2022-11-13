package by.tms.lesson36.facade;

public class Main {

    public static void main(String[] args) {
        PhoneFacade phoneFacade = new PhoneFacade(new Phone());
        phoneFacade.turnOn();
        phoneFacade.turnOff();
    }
}
