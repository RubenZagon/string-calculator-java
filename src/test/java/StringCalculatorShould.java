
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


}
