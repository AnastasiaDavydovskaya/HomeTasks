package by.tms.regularexpressionsanddates;

import by.tms.regularexpressionsanddates.task1and2.util.RegularExpressionsUtils;
import by.tms.regularexpressionsanddates.task3and4.util.DatesUtils;

public class Test {

    public static void main(String[] args) {
        System.out.println(RegularExpressionsUtils.searchHexadecimalNumber("z8k4C5lmn5A3qwAop"));
        System.out.println(RegularExpressionsUtils.validateMail("inbox@google.com, nastya_davyd@list.ru, l__fil__@mail.ru, ol34_gav2_@yandex.ru"));

        System.out.println(DatesUtils.amountOfDays(2020, 6, 25));
        System.out.println(DatesUtils.amountOfSeconds(2020, 6, 25));
    }
}
