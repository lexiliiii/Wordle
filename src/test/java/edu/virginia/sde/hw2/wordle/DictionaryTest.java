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


//    @Test
//    void checkValidateWordSet(){
//        var startingWordSet = new HashSet<>(Set.of("", "Status"));
//        var dictionary = new Dictionary(startingWordSet, new WordValidator());
//
//////        var wordSet = dictionary.getWordSet();
////        WordValidator wordValidator = new WordValidator(); // Assuming this is the class that has the isValidWord method.
////        dictionary.addWord("Apple");
////        dictionary.addWord("banana");
////        dictionary.addWord("Pineapple"); // Intentionally adding a word with an uppercase letter to test lowercase validation.
//
//        var wordSet = dictionary.getWordSet();
//        for(String s : wordSet){
//            String temp = s.toLowerCase();
//            assertTrue(temp.equals(s));
//        }
//    }



    @Test
    void checkContains(){
        var dictionary = new Dictionary();

        assertTrue(!dictionary.contains("apple"));
        assertTrue(!dictionary.contains("black"));
        assertTrue(!dictionary.contains("camel"));

        dictionary.addWord("apple");
        dictionary.addWord("black");

        assertTrue(dictionary.contains("apple"));
        assertTrue(dictionary.contains("black"));
        assertTrue(!dictionary.contains("camel"));
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

        assertTrue(dictionary.size() == 3);
    }

    @Test
    void checkEquals(){
        var startingWordSet = new HashSet<>(Set.of(""));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());

//        dictionary.equals("");

        assertFalse(dictionary.equals(""));

        var dictionary1 = new Dictionary();
        dictionary1.addWord("");

        assertTrue(dictionary.equals(dictionary1));
//        assertTrue(!(a instanceof Dictionary otherDictionary));
//        assertFalse(wordSet.equals(""));

//        var startingWordSet1 = new HashSet<>(Set.of("apple", "black", "camel"));
//        var dictionary1 = new Dictionary(startingWordSet1, new WordValidator());
//
//        var wordSet1 = dictionary1.getWordSet();
////
////        String a = "apple";
////        boolean b = wordSet1.equals(a);
////        assertTrue(b == true);
////        assertFalse(wordSet.equals(a));
//        assertTrue(wordSet.equals(wordSet1));
    }

    @Test
    void checkAddWord(){
        var dictionary = new Dictionary();
        dictionary.addWord("");
        assertTrue(dictionary.contains(""));

    }

}