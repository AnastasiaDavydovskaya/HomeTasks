package by.tms.lesson36.singleton;

public class PresidentRussia {

    private static PresidentRussia presidentRussia;

    private PresidentRussia() {}

    public static PresidentRussia getPresidentRussia() {
        if(presidentRussia == null) {
            presidentRussia = new PresidentRussia();
        }

        return presidentRussia;
    }
}
