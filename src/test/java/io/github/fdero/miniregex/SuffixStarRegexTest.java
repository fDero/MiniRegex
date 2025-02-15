package io.github.fdero.miniregex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SuffixStarRegexTest {

    private final Regex regex = new ConcatRegex(
        new CharRegex('a'),
        new StarRegex(new CharRegex('b')) 
    );

    @Test
    void starMatchNoOccurrenceSuccessTest() {
        boolean isMatch = regex.matches("a");
        assertEquals(true, isMatch);
    }

    @Test
    void starMatchOneOccurrenceSuccessTest() {
        boolean isMatch = regex.matches("ab");
        assertEquals(true, isMatch);
    }

    @Test
    void starMatchTwoOccurrencesSuccessTest() {
        boolean isMatch = regex.matches("abb");
        assertEquals(true, isMatch);
    }
    
    @Test
    void starMatchNoOccurrenceFailureTest() {
        boolean isMatch = regex.matches("x");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchOneOccurrenceFailureTest() {
        boolean isMatch = regex.matches("xb");
        assertEquals(false, isMatch);
    }

    @Test
    void starMatchTwoOccurrencesFailureTest() {
        boolean isMatch = regex.matches("xbb");
        assertEquals(false, isMatch);
    }
}
