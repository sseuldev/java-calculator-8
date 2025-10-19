package calculator.domain;

import java.util.regex.Pattern;

public class Separator {

    private static final String INVALID_CUSTOM_SEPARATOR_LENGTH = "커스텀 구분자는 하나의 문자여야 합니다.";
    private static final String INVALID_CUSTOM_SEPARATOR_TYPE = "커스텀 구분자는 숫자 타입일 수 없습니다.";
    private static final String ALREADY_HAVE_BASIC_SEPARATOR = "커스텀 구분자는 기본 구분자가 아니어야 합니다.";
    private static final String BASIC_SEPARATOR = "[,:]";

    private String customSeparator = null;

    public Separator(String input) {
        setCustomSeparator(input);
    }

    public String[] splitBySeparator(String input) {
        if (customSeparator == null) {
            return input.split(BASIC_SEPARATOR);
        }
        String target = input.substring(5);
        return target.split(BASIC_SEPARATOR + "|" + customSeparator);
    }

    private void setCustomSeparator(String input) {
        if (hasCustomSetting(input)) {
            String separator = getCustomSeparator(input);
            validate(separator);
            this.customSeparator = Pattern.quote(separator);
        }
    }

    private boolean hasCustomSetting(String input) {
        return input.startsWith("//") && input.indexOf("\\n") >= 2;
    }

    private String getCustomSeparator(String input) {
        return input.substring(2, input.indexOf("\\n"));
    }

    private void validate(String separator) {
        validateNumOfSeparator(separator);
        validateLetter(separator);
        validateNotBasicSeparator(separator);
    }

    private void validateNumOfSeparator(String separator) {
        if (separator.length() != 1) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_LENGTH);
        }
    }

    private void validateLetter(String separator) {
        if (separator.matches("\\d")) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_TYPE);
        }
    }

    private void validateNotBasicSeparator(String separator) {
        if (!separator.isEmpty() && ",:".contains(separator)) {
            throw new IllegalArgumentException(ALREADY_HAVE_BASIC_SEPARATOR);
        }
    }
}