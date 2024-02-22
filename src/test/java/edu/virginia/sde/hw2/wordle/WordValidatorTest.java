package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordValidatorTest {
    private static WordValidator wordValidator;
    @BeforeAll
    public static void initialize() {
        wordValidator = new WordValidator();
    }
    @Test
    public void isValidWord_false_tooLong() {
        assertFalse(wordValidator.isValidWord("DOGGIE"));
    }

    @Test
    public void checkIsAllLetters(){
        assertTrue(wordValidator.isAllLetters(""));
        assertTrue(wordValidator.isAllLetters("apple"));
        assertTrue(wordValidator.isAllLetters("APPLE"));
        assertTrue(wordValidator.isAllLetters("Apple"));
        assertTrue(wordValidator.isAllLetters("ApPlE"));
        assertTrue(wordValidator.isAllLetters("banana"));
        assertFalse(wordValidator.isAllLetters("a1ppl"));
        assertFalse(wordValidator.isAllLetters("a@ppl"));

    }
}
