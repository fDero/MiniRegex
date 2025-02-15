package io.github.fdero.miniregex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InfixStarRegexTest {

    private final Regex regex = new ConcatRegex(
        new CharRegex('a'),
        new ConcatRegex(
            new StarRegex(new CharRegex('b')),
            new CharRegex('c')
        )
    );

    @Test
    void starMatchNoOccurrenceSuccessTest() {
        boolean isMatch = regex.matches("ac");
        assertEquals(true, isMatch);
    }

    @Test
    void starMatchOneOccurrenceSuccessTest() {
        boolean isMatch = regex.matches("abc");
        assertEquals(true, isMatch);
    }

    @Test
    void starMatchTwoOccurrencesSuccessTest() {
        boolean isMatch = regex.matches("abbc");
        assertEquals(true, isMatch);
    }
    
    @Test
    void starMatchMissingFrontNoOccurrenceFailureTest() {
        boolean isMatch = regex.matches("xc");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchMissingBackNoOccurrenceFailureTest() {
        boolean isMatch = regex.matches("ax");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchMissingFrontOneOccurrenceFailureTest() {
        boolean isMatch = regex.matches("xbc");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchMissingFrontTwoOccurrencesFailureTest() {
        boolean isMatch = regex.matches("xbbc");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchMissingBackOneOccurrenceFailureTest() {
        boolean isMatch = regex.matches("abx");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchMissingBackTwoOccurrencesFailureTest() {
        boolean isMatch = regex.matches("abbx");
        assertEquals(false, isMatch);
    }
}
