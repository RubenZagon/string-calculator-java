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
        String[] stringNumbers = text
                .replace("/", delimiter)
                .replace("\n", delimiter)
                .split(delimiter);
        int result = 0;
        for (String value : stringNumbers) {
            if (!value.isEmpty()) {
                result += parseInt(value.replace("", " ").trim());
            }
        }

        return result;
    }
}
