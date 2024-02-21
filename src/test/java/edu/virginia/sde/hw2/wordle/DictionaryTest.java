package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.BeanProperty;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void getWordSet() {
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());

        var wordSet = dictionary.getWordSet();
        assertEquals(3, wordSet.size());
        assertTrue(wordSet.contains("apple"));
        assertTrue(wordSet.contains("black"));
        assertTrue(wordSet.contains("camel"));
    }

    @Test
    void getWordSet_initiallyEmpty() {
        var dictionary = new Dictionary();

        var wordSet = dictionary.getWordSet();
        assertTrue(wordSet.isEmpty());
    }

    @Test
    void checkContains(){
        var dictionary = new Dictionary();

        assertFalse(dictionary.contains("apple"));
        assertFalse(dictionary.contains("black"));
        assertFalse(dictionary.contains("camel"));

        dictionary.addWord("apple");
        dictionary.addWord("black");
        dictionary.addWord("APPLE");

        assertTrue(dictionary.contains("apple"));
        assertTrue(dictionary.contains("black"));
        assertFalse(dictionary.contains("camel"));

    }

    @Test
    void checkSize(){
        var dictionary = new Dictionary();

        assertTrue(dictionary.size() == 0);

        dictionary.addWord("apple");
        dictionary.addWord("black");
        dictionary.addWord("camel");
        dictionary.addWord("!pple");
        dictionary.addWord("banana");

        assertTrue(dictionary.size() == 3);
    }

    @Test
    void checkAddWord(){
        var dictionary = new Dictionary();
        dictionary.addWord("");
        dictionary.addWord("apple");
        dictionary.addWord("black");
        dictionary.addWord("camel");
        dictionary.addWord("banana");
        dictionary.addWord("!appl");

        assertFalse(dictionary.contains(""));
        assertTrue(dictionary.contains("apple"));
        assertTrue(dictionary.contains("black"));
        assertTrue(dictionary.contains("CAMEL"));
        assertFalse(dictionary.contains("banana"));
        assertFalse(dictionary.contains("!appl"));

    }
}