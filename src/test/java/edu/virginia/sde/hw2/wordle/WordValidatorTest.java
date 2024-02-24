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
    public void validWordIsAllLetters(){
        assertTrue(wordValidator.isAllLetters("apple"));
    }

    @Test
    public void UpperCaseIsAllLetters(){
        assertTrue(wordValidator.isAllLetters("APPLE"));
    }


    @Test
    public void EmptyStringIsAllLetters(){
        assertFalse(wordValidator.isAllLetters(""));
    }


    @Test
    public void containsNumberIsAllLetters(){
        assertFalse(wordValidator.isAllLetters("a1ppl"));
    }

    @Test
    public void containsSymbolIsAllLetters(){
        assertFalse(wordValidator.isAllLetters("a@ppl"));
    }
}
