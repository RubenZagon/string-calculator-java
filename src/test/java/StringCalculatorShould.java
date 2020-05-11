
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {

    @Test
    public void return_0_empty_string(){
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void return_the_same_number_without_commas_string(){
        assertThat(StringCalculator.add("3")).isEqualTo(3);
    }

    @Test
    public void handle_an_unknown_amount_of_numbers(){
        assertThat(StringCalculator.add("5,3")).isEqualTo(8);
        assertThat(StringCalculator.add("3, 5, 7")).isEqualTo(15);
    }


}
