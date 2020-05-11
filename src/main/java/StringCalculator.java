import static java.lang.Integer.parseInt;

public class StringCalculator {

    private StringCalculator() {
        //No need arguments
    }

    public static Integer add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        if (!text.contains(",")) {
            return parseInt(text);
        }

        String[] stringNumbers = text.replaceAll("\n", ",")
                                 .split(",");
        int result = 0;
        for (String value : stringNumbers) {
            result += parseInt(value.trim());
        }


        return result;
    }
}
