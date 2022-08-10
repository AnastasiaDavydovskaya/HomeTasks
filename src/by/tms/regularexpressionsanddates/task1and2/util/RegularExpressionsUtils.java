package by.tms.regularexpressionsanddates.task1and2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegularExpressionsUtils {

    private RegularExpressionsUtils() {
    }

    public static List<String> validateMail(String string) {
        return findRegularExpressionInString(string, "[A-Za-z][\\dA-Za-z_]+@[a-z]+\\.[a-z]+");
    }

    public static List<String> searchHexadecimalNumber(String string) {
        return findRegularExpressionInString(string, "[0-9a-fA-F]+");
    }

    private static List<String> findRegularExpressionInString(String string, String pattern) {
        List<String> list = new ArrayList<>();
        Pattern expression = Pattern.compile(pattern);
        Matcher matcher = expression.matcher(string);

        while (matcher.find()) {
            list.add(matcher.group());
        }

        return list;
    }
}
