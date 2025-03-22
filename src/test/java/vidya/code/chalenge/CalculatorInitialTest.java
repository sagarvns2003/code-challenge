package vidya.code.chalenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorInitialTest {

    private final CalculatorInitial underTest = new CalculatorInitial();



    @Test
    void shouldAdd() {
        // given
        // when
        var actual = underTest.calculate("1 2 +");
        // then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    //@ParameterizedTest
    //@ValueSource()
    void shouldSubtract() {
        // given
        // when
        var actual = underTest.calculate("2 4 -");  // 2 - 4 == - 2
        // then
        assertThat(actual).isEqualTo(-2.0);
    }

    @Test
    void shouldDivide() {
        // given
        // when
        var actual = underTest.calculate("4 3 /");
        // then
       // assertThat(actual).isCloseTo(); //isEqualTo(1.33);
    }

    @Test
    void shouldMultiply() {
        // given
        // when
        var actual = underTest.calculate("3 2 *");
        // then
        assertThat(actual).isEqualTo(6);
    }

}
