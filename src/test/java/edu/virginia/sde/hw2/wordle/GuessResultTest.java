package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;

import static edu.virginia.sde.hw2.wordle.LetterResult.*;
import static edu.virginia.sde.hw2.wordle.GuessResult.*;

import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {
    @Test
    public void getLetterResultTest() {
        GuessResult result = new GuessResult("guess", "guess");
        LetterResult[] expected = {
                LetterResult.GREEN,
                LetterResult.GREEN,
                LetterResult.GREEN,
                LetterResult.GREEN,
                LetterResult.GREEN };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void regularResultTest() {
        GuessResult result = new GuessResult("brain", "basic");
        LetterResult[] expected = { LetterResult.GREEN, GRAY, YELLOW, GREEN, GRAY };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void upperCaseGuessResultTest() {
        GuessResult result = new GuessResult("BRAIN", "basic");
        LetterResult[] expected = { LetterResult.GREEN, GRAY, YELLOW, GREEN, GRAY };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void duplicateResultTest_misSingleToDouble() {
        GuessResult result = new GuessResult("party", "happy");
        LetterResult[] expected = { YELLOW, GREEN, GRAY, GRAY, GREEN };
        assertArrayEquals( expected, result.getLetterResults() );
    }


    @Test
    public void duplicateResultTest_rightSingleToDouble() {
        GuessResult result = new GuessResult("drape", "happy");
        LetterResult[] expected = { GRAY, GRAY, YELLOW, GREEN, GRAY };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void duplicateResultTest_misDoubleToDouble() {
        GuessResult result = new GuessResult("adapt", "salad");
        LetterResult[] expected = { YELLOW, YELLOW, YELLOW, GRAY, GRAY };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void duplicateResultTest_rightDoubleToDouble() {
        GuessResult result = new GuessResult("canal", "salad");
        LetterResult[] expected = { GRAY, GREEN, GRAY, GREEN, YELLOW };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void duplicateResultTest_misSingleToTriple() {
        GuessResult result = new GuessResult("spray", "puppy");
        LetterResult[] expected = { GRAY, YELLOW, GRAY, GRAY, GREEN };
        assertArrayEquals( expected, result.getLetterResults() );
    }


    @Test
    public void duplicateResultTest_rightSingleToTriple() {
        GuessResult result = new GuessResult("loopy", "puppy");
        LetterResult[] expected = { GRAY, GRAY, GRAY, GREEN, GREEN };
        assertArrayEquals( expected, result.getLetterResults() );
    }


    @Test
    public void duplicateResultTest_misDoubleToTriple() {
        GuessResult result = new GuessResult("apple", "puppy");
        LetterResult[] expected = { GRAY, YELLOW, GREEN, GRAY, GRAY };
        assertArrayEquals( expected, result.getLetterResults() );
    }

    @Test
    public void duplicateResultTest_TripeToDouble() {
        GuessResult result = new GuessResult("puppy", "apple");
        LetterResult[] expected = { YELLOW, GRAY, GREEN, GRAY, GRAY };
        assertArrayEquals( expected, result.getLetterResults() );
    }


    @Test
    public void badInputResultTest_NotWord() {
        assertThrows( Exception.class, () -> new GuessResult("12345", "apple").getLetterResults());
    }

    @Test
    public void badInputResultTest_Length() {
        assertThrows( Exception.class, () -> new GuessResult("red", "apple").getLetterResults());
    }



}
