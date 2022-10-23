package by.tms.lesson31.additionaltask1;

public class Division {

    private Long counter = 0L;

    public Long divide(Long first, Long second) {
        if(first != null && second != null) {
            counter = 0L;

            while (first >= second) {
                counter++;
                first -= second;
            }

            return counter;
        } else {
            return 0L;
        }
    }
}
