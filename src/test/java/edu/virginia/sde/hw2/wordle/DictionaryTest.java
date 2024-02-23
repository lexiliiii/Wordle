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
    void checkContainsUppercase1(){
        var dictionary = new Dictionary();

        dictionary.addWord("WHITE");

        assertTrue(dictionary.contains("white"));

    }

    @Test
    void checkSize(){
        var dictionary = new Dictionary();
        assertEquals(0, dictionary.size());

        var dictionary1 = new Dictionary();

        dictionary1.addWord("apple");
        dictionary1.addWord("black");
        dictionary1.addWord("camel");

        assertTrue(dictionary1.size() == 3);
    }


    @Test
    void checkAddEmptyString(){
        var dictionary = new Dictionary();
        assertThrows(IllegalArgumentException.class, () -> dictionary.addWord(""));
    }

    @Test
    void checkAddWord(){
        var dictionary = new Dictionary();
        dictionary.addWord("apple");

        assertTrue(dictionary.contains("apple"));
    }

    @Test
    void checkAddUpperCase(){
        var dictionary = new Dictionary();
        dictionary.addWord("CAMEL");

        assertTrue(dictionary.contains("camel"));
    }

    @Test
    void AddLongWords(){
        var dictionary = new Dictionary();
        assertThrows(IllegalArgumentException.class, () -> dictionary.addWord("banana"));
    }

    @Test
    void checkAddNotAWord(){
        var dictionary = new Dictionary();
        assertThrows(IllegalArgumentException.class, () -> dictionary.addWord("a!ple"));
    }

    @Test
    void checkAddUnusualWord(){
        var dictionary = new Dictionary();
        dictionary.addWord("TeaCh");

        assertTrue(dictionary.contains("teach"));

    }


}