package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SeparatorTest {

    @DisplayName("기본 및 커스텀 구분자에 따른 숫자 분리 성공")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3', '1|2|3'",
            "'5:6', '5|6'",
            "'1,2:3', '1|2|3'",
            "'//*\\n1*2*3', '1|2|3'",
            "'//+\\n1+2+3', '1|2|3'",
            "'//+\\n1,2:3', '1|2|3'",
            "'//&\\n1&2,3&4', '1|2|3|4'",
    })
    void splitBySeparatorTest(String input, String expectedString) {
        // given
        Separator separator = new Separator(input);
        String[] expected = expectedString.split("\\|");

        // when
        String[] result = separator.splitBySeparator(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("빈 문자열이 들어간 경우 처리 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,:3", "//\\n123", "", "//+\\n1++3"})
    void successEmptyTest(String input) {
        // given

        // when, then
        assertThatCode(() -> new Separator(input)).doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자가 문자가 아닌 숫자인 경우 : 예외 발생")
    @Test
    void validateCustomTypeTest() {
        // given
        String input = "//1\\n111";

        // when, then
        assertThatThrownBy(() -> new Separator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 숫자 타입일 수 없습니다.");
    }

    @DisplayName("커스텀 구분자가 두 개 이상인 경우 : 예외 발생")
    @Test
    void validateNumOfCustomTest() {
        // given
        String input = "//++\\n1,2,3";

        // when, then
        assertThatThrownBy(() -> new Separator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 하나의 문자여야 합니다.");
    }

    @DisplayName("커스텀 구분자가 기본 구분자 중 하나인 경우 : 예외 발생")
    @Test
    void validateCustomIsNotBasicTest() {
        // given
        String input = "//,\\n1,2,3";

        // when, then
        assertThatThrownBy(() -> new Separator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 기본 구분자가 아니어야 합니다.");
    }
}
