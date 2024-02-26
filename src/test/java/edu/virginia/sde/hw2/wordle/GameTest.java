package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static edu.virginia.sde.hw2.wordle.GameStatus.*;
import static edu.virginia.sde.hw2.wordle.LetterResult.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Dictionary defaultGuessesDictionary, defaultAnswersDictionary;

    @BeforeAll
    public static void initialize() {
        defaultGuessesDictionary = DefaultDictionaries.getGuessesDictionary();
        defaultAnswersDictionary = DefaultDictionaries.getAnswersDictionary();
    }

    @Test
    public void test_init_zeroArgumentConstructor() {
        var game = new Game();

        assertEquals(defaultGuessesDictionary, game.getGuessDictionary());
        assertTrue(defaultAnswersDictionary.contains(game.getAnswer()));
        assertEquals(6, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
    }

    @Test
    public void test_init_4ArgumentConstructor() {
        var game = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);

        assertEquals(defaultGuessesDictionary, game.getGuessDictionary());
        assertEquals("TREND", game.getAnswer());
        assertEquals(6, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
    }

    @Test
    public void test_isGameOver_WIN_True() {
        var game = new Game(defaultGuessesDictionary, "TREND", 5, WIN);

        assertEquals(WIN, game.getGameStatus());
        assertTrue(game.isGameOver());
    }


    @Test
    public void test_isGameOver_Loss_True() {
        var game1 = new Game(defaultGuessesDictionary, "TREND", 1, PLAYING);
        game1.submitGuess("white");
        assertEquals(0, game1.getGuessesRemaining());
        assertEquals(LOSS, game1.getGameStatus());
        assertTrue(game1.isGameOver());
    }

    @Test
    public void test_submitGuess_Status_PLAYING() {
        var game = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);
        game.submitGuess("white");
        assertEquals(5, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
        assertFalse(game.isGameOver());
    }

    @Test
    public void test_submitGuess_Equivalence_PLAYING() {
        var game = new Game(defaultGuessesDictionary, "TREND", 5, PLAYING);
        game.submitGuess("white");
        assertEquals(4, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
        assertFalse(game.isGameOver());
    }

    @Test
    public void test_submitGuess_Status_Boundary_WIN() {
        var game = new Game(defaultGuessesDictionary, "TREND", 1, PLAYING);
        game.submitGuess("TREND");
        assertEquals(0, game.getGuessesRemaining());
        assertEquals(WIN, game.getGameStatus());
        assertTrue(game.isGameOver());
    }
    @Test
    public void test_submitGuess_Status_WIN() {
        var game = new Game(defaultGuessesDictionary, "TREND", 4, PLAYING);
        game.submitGuess("TREND");
        assertEquals(3, game.getGuessesRemaining());
        assertEquals(WIN, game.getGameStatus());
        assertTrue(game.isGameOver());
    }
    @Test
    void InvalidWordGetThrowsExceptions() {
        var game = new Game();
        assertThrows(IllegalWordException.class,
                () -> game.submitGuess("huetf"));
    }
    @Test
    void GameAlreadyWINThrowsException() {
        var game1 = new Game(defaultGuessesDictionary, "TREND", 2, WIN);
        assertThrows(GameAlreadyOverException.class,
                () -> game1.submitGuess("white"));
    }
    @Test
    void GameAlreadyLOSSThrowsException() {
        var game2 = new Game(defaultGuessesDictionary, "TREND", 0, LOSS);
        assertThrows(GameAlreadyOverException.class,
                () -> game2.submitGuess("white"));
    }
    @Test
    void EmptyInputGetThrowsExceptions() {
        var game = new Game();
        assertThrows(IllegalArgumentException.class,
                () -> game.submitGuess(""));
    }
    @Test
    void NullInputGetThrowsExceptions() {
        var game = new Game();
        String input=null;
        assertThrows(NullPointerException.class,
                () -> game.submitGuess(input));
    }
    @Test
    void EmptyDictionaryThrowsException() {
        Dictionary newbook=new Dictionary();
        Exception exception=assertThrows(IllegalArgumentException.class,()->new Game(newbook, "TREND", 4, PLAYING));
        assertEquals("Cannot create a Game with an empty guessDictionary",exception.getMessage());

    }
    @Test
    void InvalidGameStatus0_PlayingThrowsException() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->new Game(defaultGuessesDictionary, "TREND", 0, PLAYING));
        assertEquals("The game cannot be in a PLAYING state with zero guesses remaining",exception.getMessage());
    }
    @Test
    void InvalidGameStatus2_LOSSThrowsException() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->new Game(defaultGuessesDictionary, "TREND", 2, LOSS));
        assertEquals("The game cannot be in a LOSS state with more than zero guesses remaining",exception.getMessage());
    }
    @Test
    void InvalidGameStatus_NULL_ThrowsException() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->new Game(defaultGuessesDictionary, "TREND", 2, null));
        assertEquals("gameStatus cannot be null",exception.getMessage());
    }


















}