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
    void caseInsensitive(){
        var dictionary = new Dictionary();

        var wordSet = dictionary.getWordSet();
        wordSet.add("APPLE");
        wordSet.add("banana");
        assertTrue(wordSet.contains("apple"));
        assertTrue(wordSet.contains("BANANA"));
    }
//
//    @Test
//    void ableToAddWord(){
//        var dictionary = new Dictionary();
//
//        var wordSet = dictionary.getWordSet();
//        assertTrue(wordSet.add("apple"));
//    }

    @Test
    void IllegalWords(){
        var dictionary = new Dictionary();

        var wordSet = dictionary.getWordSet();
        wordSet.add("wocao");
        wordSet.add("apple3");
        assertTrue(wordSet.isEmpty());
//        wordSet.add("apple");
//        assertTrue(wordSet.contains("apple"));
    }

    @Test
    void checkLowercase(){
        var dictionary = new Dictionary();
        dictionary.addWord("APPLE");
        dictionary.addWord("BANANA");
        dictionary.addWord("PINEAPPLE");

        var wordSet = dictionary.getWordSet();
        for(String s : wordSet){
            String wocao = s.toLowerCase();
            assertTrue(wocao.equals(s));
        }
        Set<String> result = dictionary.getWordSet();
    }

//    @Test
//    void equalWords(){
//        var dictionary = new Dictionary();
//        var wordSet = dictionary.getWordSet();
//
//        var dictionary1 = new Dictionary();
//        var wordSet1 = dictionary1.getWordSet();
//
//        wordSet.add("apple");
//        wordSet1.add("apple");
//        assertTrue(wordSet.equals(wordSet1));
//    }

//    @Test
//    void sizeCheck(){
//        var dictionary = new Dictionary();
//        var wordSet = dictionary.getWordSet();
//        assertTrue(wordSet.size() == 0);
//        wordSet.add("apple");
//        wordSet.add("banana");
//        wordSet.add("pineapple");
//        wordSet.add("wwrong");
//        int size = wordSet.size();
//        assertTrue(size == 3);
//    }

    @Test
    void sizeCheck(){
        var dictionary = new Dictionary();
        assertTrue(dictionary.size() == 0); // Use Dictionary's size method

        dictionary.addWord("apple");    // Use Dictionary's method to add words, assuming such a method exists
        dictionary.addWord("banana");
        dictionary.addWord("pineapple");
        dictionary.addWord("wrong");    // Assuming you handle adding only valid words within addWord method

        int size = dictionary.size();   // Again, use Dictionary's size method
        assertTrue(size == 3);          // Assuming you want the size to be 3 after adding the words
    }


    @Test
    void checkEmpty(){
        var dictionary = new Dictionary();
        var wordSet = dictionary.getWordSet();
        wordSet.add("apple");
        assertFalse(wordSet.isEmpty());
//        assertTrue(!wordSet.isEmpty());
    }
}