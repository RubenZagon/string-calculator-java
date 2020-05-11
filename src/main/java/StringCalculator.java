import static java.lang.Integer.parseInt;

public class StringCalculator {

    private StringCalculator() {
        //No need arguments
    }

    public static Integer add(String text){
        if (text.isEmpty()){
        return 0;
        }

        return parseInt(text);
    }
}
