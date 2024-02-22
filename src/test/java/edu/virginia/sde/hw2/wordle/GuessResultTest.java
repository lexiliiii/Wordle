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


}
