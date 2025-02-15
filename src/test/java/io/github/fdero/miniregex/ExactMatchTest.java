package io.github.fdero.miniregex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExactMatchTest {

    Regex regex = new ConcatRegex(
        new CharRegex('a'), 
        new CharRegex('b')
    );

    @Test
    void exactMatchSuccessTest() {    
        boolean isMatch = regex.matches("ab");
        assertEquals(true, isMatch);
    }
    
    @Test
    void exactMatchTooShortTest() {    
        boolean isMatch = regex.matches("a");
        assertEquals(false, isMatch);
    }

    @Test
    void exactMatchTooLongTest() {    
        boolean isMatch = regex.matches("aab");
        assertEquals(false, isMatch);
    }

    @Test
    void exactMatchTooLong2Test() {    
        boolean isMatch = regex.matches("abb");
        assertEquals(false, isMatch);
    }
}
