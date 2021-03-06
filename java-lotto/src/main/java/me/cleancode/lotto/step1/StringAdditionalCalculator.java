package me.cleancode.lotto.step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionalCalculator {
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER_STRING = ",|:";
    private static final int EXPRESSION = 2;
    private static final int DELIMITER = 1;

    private StringAdditionalCalculator() {
    }

    static int splitAndSum(String text) {
        if (text == null || "".equals(text.trim())) {
            return 0;
        }
        String[] numbers = getNumbers(text);
        return Arrays.stream(numbers)
            .mapToInt(StringAdditionalCalculator::parseNumber)
            .sum();
    }

    static String[] getNumbers(String text) {
        Matcher m = pattern.matcher(text);
        return m.find()
            ? m.group(EXPRESSION).split(m.group(DELIMITER))
            : text.split(DELIMITER_STRING);
    }

    static int parseNumber(String text) {
        validatedNumber(text);
        return Integer.parseInt(text);
    }

    static void validatedNumber(String text) {
        try {
            if (Integer.parseInt(text) < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
