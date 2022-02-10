package com.company;
import  java.util.*;
public class SpellChecker {
    private static  String  dictionary;
    private static  int  int_dictionary;

    private SpellChecker(String dictionary) {
        SpellChecker.dictionary =dictionary;
    }
    private SpellChecker(int dictionary) {
        SpellChecker.int_dictionary=dictionary;
    }// Noninstantiable
    public static boolean isValid(String word) { return true; }
    public static List<String> suggestions(String typo) { return new ArrayList<>(); }
}
