package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
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
    void checkIsEmpty(){
        var dictionary = new Dictionary();
        assertTrue(dictionary.isEmpty());

        dictionary.addWord("apple");
        assertTrue(!dictionary.isEmpty());
    }

    @Test
    void checkSize(){
        var dictionary = new Dictionary();
        assertTrue(dictionary.size() == 0);

        dictionary.addWord("apple");
        dictionary.addWord("banana");
        dictionary.addWord("pineapple");
        dictionary.addWord("wrong");

        assertTrue(dictionary.size() == 3);
    }

}