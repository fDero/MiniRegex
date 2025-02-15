package io.github.fdero.miniregex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrefixStarRegexTest {

    private final Regex regex = new ConcatRegex(
        new StarRegex(new CharRegex('a')), 
        new CharRegex('b')
    );

    @Test
    void starMatchNoOccurrenceSuccessTest() {
        boolean isMatch = regex.matches("b");
        assertEquals(true, isMatch);
    }

    @Test
    void starMatchOneOccurrenceSuccessTest() {
        boolean isMatch = regex.matches("ab");
        assertEquals(true, isMatch);
    }

    @Test
    void starMatchTwoOccurrencesSuccessTest() {
        boolean isMatch = regex.matches("aab");
        assertEquals(true, isMatch);
    }
    
    @Test
    void starMatchNoOccurrenceFailureTest() {
        boolean isMatch = regex.matches("x");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchOneOccurrenceFailureTest() {
        boolean isMatch = regex.matches("ax");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchTwoOccurrencesFailureTest() {
        boolean isMatch = regex.matches("aax");
        assertEquals(false, isMatch);
    }
}
