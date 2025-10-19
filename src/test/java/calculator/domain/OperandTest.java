package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @DisplayName("피연산자가 숫자가 아닌 경우 : 예외 발생")
    @Test
    void validateOperandIsNotNumberTest() {
        // given
        String input = "1,2:a";
        Separator separator = new Separator(input);
        String[] result = separator.splitBySeparator(input);

        // when, then
        assertThatThrownBy(() -> new Operands(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("피연산자는 숫자여야 합니다.");
    }

    @DisplayName("피연산자가 음수인 경우 : 예외 발생")
    @Test
    void validatePositiveTest() {
        // given
        String input = "1,2:-5";
        Separator separator = new Separator(input);
        String[] result = separator.splitBySeparator(input);

        // when, then
        assertThatThrownBy(() -> new Operands(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("피연산자는 양수여야 합니다.");
    }
}
