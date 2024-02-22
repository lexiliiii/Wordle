package edu.virginia.sde.hw2.wordle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.virginia.sde.hw2.wordle.LetterResult.*;

/**
 * This class handles getting the result from a guess in a Wordle Game. This class is used by
 * {@link Game#submitGuess(String)}.
 */
public class GuessResult {
    private final String guess;
    private final String answer;

    /**
     * Constructor for GuessResult
     * @param guess - the Wordle player's guessed word
     * @param answer - the word the player is trying to guess
     * @throws IllegalArgumentException if either word is not 5-characters long.
     */
    public GuessResult(String guess, String answer) {
        validateWordLengths(guess, answer);
        this.guess = guess;
        this.answer = answer;
    }

    private static void validateWordLengths(String guess, String answer) {
        if (guess.length() != WordValidator.WORDLE_WORD_LENGTH || answer.length() != WordValidator.WORDLE_WORD_LENGTH) {
            throw new IllegalArgumentException(String.format("""
                            Invalid GuessResult initialization:
                                guess: %s
                                answer: %s
                            Words must be %d letters long.""",
                    guess, answer, WordValidator.WORDLE_WORD_LENGTH));
        }
    }

    /**
     * Returns the guess submitted by the player.
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Returns the answer the player is trying to guess.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns true if the player's guess matches the answer (case-insensitive)
     */
    public boolean isCorrect() {
        //TODO: Stub
        return false;
    }

    /**
     * Returns the {@link LetterResult} array of GREEN, YELLOW, and GRAY based on how well the player's guess. This
     * function is case-insensitive.
     */
    public LetterResult[] getLetterResults() {
        LetterResult[] result = new LetterResult[ 5 ];
        String g = getGuess().toUpperCase();
        String a = getAnswer().toUpperCase();

        boolean[] usedRecord = { false, false, false, false, false };

        for ( int i = 0; i < g.length(); i++ ) {
            if ( g.charAt(i) == a.charAt(i) ) {
                result[i] = LetterResult.GREEN;
                usedRecord[ i ] = true;
            }
        }

        for ( int i = 0; i < g.length(); i++ ){
            if ( g.charAt(i) != a.charAt(i) ) {
                boolean in = false;
                boolean stop = false;
                for ( int k = 0; k < a.length(); k++ ){
                    if ( g.charAt( i ) == a.charAt( k ) && usedRecord[k] == false && stop == false ){
//                        System.out.println("i: " + i + "; k:" + k + "; Used: " +usedRecord[k] );
                        result[ i ] = LetterResult.YELLOW;
                        usedRecord[ k ] = true;
                        in = true;
                        stop = true;
                    }
                }
                if ( !in ){
                    result[ i ] = LetterResult.GRAY;
                }
            }
        }
        return result;
    }


}
