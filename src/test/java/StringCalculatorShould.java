
import org.junit.Ignore;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {

    @Test
    public void handle_empty_string() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void handle_string_without_commas() {
        assertThat(StringCalculator.add("3")).isEqualTo(3);
    }

    @Test
    public void handle_an_unknown_amount_of_numbers() {
        assertThat(StringCalculator.add("5,3")).isEqualTo(8);
        assertThat(StringCalculator.add("3, 5, 7")).isEqualTo(15);
    }

    @Test
    public void handle_new_lines_between_numbers() {
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);
    }

    @Ignore
    @Test
    public void support_different_delimiters() {
        /*

         "//[delimiter]\n[numbers...]"

         */

        assertThat(StringCalculator.add("5,3")).isEqualTo(8);
    }


}
