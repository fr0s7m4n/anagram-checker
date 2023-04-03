package com.timmoroz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static com.timmoroz.AnagramChecker.isLetterBasedAnagram;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests {@link AnagramChecker}.
 */
class AnagramCheckerCheckerTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "ABCXYZabcxyz123?!,.-;:(){}  |  abcxyzabcxyz",
            "Santa; shy, less cruel|santashylesscruel"})
    void reduceToLowerCaseLetters(String input, String output) {
        assertThat(AnagramChecker.reduceToLowerCaseLetters(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "teacher|cheater",
            "funeral|real fun",
            "a gentleman|elegant man",
            "I’m a dot in place.|A decimal point"})
    void isAnagram(String string1, String string2) {
        assertThat(isLetterBasedAnagram(string1, string2)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "dog|cat",
            "bed|bad"})
    void isNotAnagramDifferentLetters(String string1, String string2) {
        assertThat(isLetterBasedAnagram(string1, string2)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "a|aa",
            "bb|bbb",
            "o|ooooooooooooooooooooooooooooooooooooooo"})
    void isNotAnagramDifferentLength(String string1, String string2) {
        assertThat(isLetterBasedAnagram(string1, string2)).isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void throwsExceptionWhenNullOrEmptyParameters(String string) {
        assertThatThrownBy(() -> isLetterBasedAnagram(string, string))
                .hasMessage("Parameters cannot be null or blank")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
