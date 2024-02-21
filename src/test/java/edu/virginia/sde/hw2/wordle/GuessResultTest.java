package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;

import static edu.virginia.sde.hw2.wordle.LetterResult.*;
import static edu.virginia.sde.hw2.wordle.GuessResult.*;

import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {
    @Test
    public void getLetterResultTest() {
        GuessResult result = new GuessResult("guess", "guess");
        LetterResult[] expected = {LetterResult.GREEN,LetterResult.GREEN,LetterResult.GREEN,LetterResult.GREEN,LetterResult.GREEN};
        assertArrayEquals( expected, result.getLetterResults() );
    }


}
