package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CalculatorTest {

    @DisplayName("계산기 덧셈 성공")
    @ParameterizedTest
    @CsvSource({
            "'1,2:3', '6'",
            "'//&\\n1&2,3&4', '10'",
    })
    void successCalculatorTest(String input, int expected) {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
