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

        int result = 0;
        String[] splitText = text.split(",");
        for (String value: splitText) {
            result += parseInt(value.trim());
        }


        return result;
    }
}
