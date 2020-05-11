import exceptions.NegativeNumbersNotAllowedException;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    private StringCalculator() {
        //No need arguments
    }

    public static Integer add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        boolean isASimpleNumber = !text.contains(",") && !text.contains("//");
        if (isASimpleNumber) {
            return parseInt(text.trim());
        }

        boolean foundCustomDelimiter = text.contains("//") && text.contains("\n");
        if (foundCustomDelimiter) {
            String delimiter = findDelimiter(text);
            return calculateWithDelimiters(text, delimiter);
        }

        return calculateWithDelimiters(text, ",");
    }

    private static String findDelimiter(String text) {
        String[] separateDelimiter = text.split("\n");
        return separateDelimiter[0].replace("/", "").trim();
    }

    private static Integer calculateWithDelimiters(String text, String delimiter) {
        int maxRangeAllowed = 1000;
        String[] stringNumbers = text
                .replace("/", delimiter)
                .replace("\n", delimiter)
                .split(delimiter);
        int result = 0;
        for (String value : stringNumbers) {
            try {
                int parseValueToInt = parseInt(value.trim());

                findNegativeNumbers(value, parseValueToInt);

                boolean valueOnAllowRange = parseValueToInt <= maxRangeAllowed;
                if (valueOnAllowRange) {
                    result += parseValueToInt;
                }
            } catch (NumberFormatException ex) {
                result += 0;
            }
        }

        return result;
    }

    private static void findNegativeNumbers(String value, int parseValueToInt) {
        boolean negativeValue = parseValueToInt < 0;
        if (negativeValue) {
            throw new NegativeNumbersNotAllowedException("Negatives not allowed: " + value);
        }
    }
}
