package dk.kec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class CodeInterviewTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2, true, DefaultValue, 2",
            "2, false, DefaultValue, DefaultValue",
            "NIL, true, DefaultValue, NIL",
            "NIL, false, DefaultValue, DefaultValue",
    }, nullValues = "NIL")
    void returnIfValid(Integer input, boolean isValid, String defaultValue, String expected) {
        // Given
        CodeInterview<Integer, String> codeInterview = new CodeInterview<>();
        codeInterview.setInput(input);

        Function<Integer, String> mapper = in -> in != null ? String.valueOf(in) : null;
        Predicate<String> validator = in -> isValid;
        Supplier<String> fallback = () -> defaultValue;

        // When
        String mappedValue = codeInterview.returnIfValid(mapper, validator, fallback);

        // Then
        Assertions.assertEquals(expected, mappedValue);
    }
}