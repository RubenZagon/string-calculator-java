import static java.lang.Integer.parseInt;

public class StringCalculator {

    private StringCalculator() {
        //No need arguments
    }

    public static Integer add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        if (!text.contains(",") && !text.contains("//")) {
            return parseInt(text.trim());
        }

        boolean foundCustomDelimiter = text.contains("//") && text.contains("\n");
        if (foundCustomDelimiter) {
            String[] separateDelimiter = text.split("\n");
            String customDelimiter = separateDelimiter[0].replace("/", "").trim();

            String numbers = separateDelimiter[1];
            return calculateWithDelimiters(numbers, customDelimiter);
        }

        return calculateWithDelimiters(text, ",");
    }

    private static Integer calculateWithDelimiters(String text, String delimiter) {
        String[] stringNumbers = text
                .replaceAll("\n", delimiter)
                .split(delimiter);
        int result = 0;
        for (String value : stringNumbers) {
            result += parseInt(value.trim());
        }

        return result;
    }
}
