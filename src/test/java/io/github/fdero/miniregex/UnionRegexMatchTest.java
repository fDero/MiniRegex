package io.github.fdero.miniregex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnionRegexMatchTest {
    
    private final Regex regex = new UnionRegex(
        new CharRegex('a'),
        new CharRegex('b') 
    );

    @Test
    void unionMatchLxMatchSuccessTest() {
        boolean isMatch = regex.matches("a");
        assertEquals(true, isMatch);
    }
    
    @Test
    void unionMatchRxMatchSuccessTest() {
        boolean isMatch = regex.matches("b");
        assertEquals(true, isMatch);
    }
    
    @Test
    void unionMatchFailureTest() {
        boolean isMatch = regex.matches("x");
        assertEquals(false, isMatch);
    }

    @Test
    void unionMatchFailureOnEmptyTest() {
        boolean isMatch = regex.matches("");
        assertEquals(false, isMatch);
    }

    private final Regex optional = new UnionRegex(
        new CharRegex('a'),
        SpecialRegex.EPS 
    );

    @Test
    void optionalMatchSuccessOnEmptyTest() {
        boolean isMatch = optional.matches("");
        assertEquals(true, isMatch);
    }
    
    @Test
    void optionalMatchSuccessOnFullTest() {
        boolean isMatch = optional.matches("a");
        assertEquals(true, isMatch);
    }
}
