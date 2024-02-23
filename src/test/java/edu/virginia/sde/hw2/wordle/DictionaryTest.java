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
    void checkNotContains(){
        var dictionary = new Dictionary();

        assertFalse(dictionary.contains("apple"));

    }

    @Test
    void checkContains(){
        var dictionary = new Dictionary();

        dictionary.addWord("apple");

        assertTrue(dictionary.contains("apple"));

    }

    @Test
    void checkContainsUppercase(){
        var dictionary = new Dictionary();

        dictionary.addWord("teach");

        assertTrue(dictionary.contains("TEACH"));

    }


    @Test
    void checkContainsUppercase1(){
        var dictionary = new Dictionary();

        dictionary.addWord("WHITE");

        assertTrue(dictionary.contains("white"));

    }


}