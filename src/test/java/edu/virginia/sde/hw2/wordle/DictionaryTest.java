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
        dictionary.addWord("CAMEL");
        dictionary.addWord("teach");

        assertTrue(dictionary.contains("apple"));
        assertTrue(dictionary.contains("black"));
        assertTrue(dictionary.contains("camel"));
        assertTrue(dictionary.contains("TEACH"));

    }

//    @Test
//    void checkSize(){
//        var dictionary = new Dictionary();
//        assertEquals(0, dictionary.size());
//
//
//        var dictionary1 = new Dictionary();
//        dictionary1.addWord("apple");
//        dictionary1.addWord("black");
//        dictionary1.addWord("camel");
//        assertEquals(3, dictionary1.size());
//    }

    @Test
    void checkSize(){
        var dictionary = new Dictionary();
        var wordSet = dictionary.getWordSet();
        assertEquals(0, dictionary.size());

        assertTrue(dictionary.size() == 0);
        assertEquals(0, wordSet.size());

        var dictionary1 = new Dictionary();

        dictionary1.addWord("apple");
        dictionary1.addWord("black");
        dictionary1.addWord("camel");

        assertTrue(dictionary.size() == 3);
        var wordSet1 = dictionary.getWordSet();
        assertEquals(3, dictionary1.size());
        assertEquals(3, wordSet1.size());
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
        dictionary.addWord("BlAcK");
        dictionary.addWord("CAMEL");


        assertFalse(dictionary.contains(""));
        assertTrue(dictionary.contains("apple"));
        assertTrue(dictionary.contains("black"));
        assertTrue(dictionary.contains("CAMEL"));
        assertFalse(dictionary.contains("banana"));
        assertFalse(dictionary.contains("!appl"));

    }
}