package com.danila.anagram.model;

import java.util.ArrayList;

public class InputData {
    private String word;
    private ArrayList<String> wordsForCompare;

    public InputData() {
    }

    public InputData(String word, ArrayList<String> wordsForCompare) {
        this.word = word;
        this.wordsForCompare = wordsForCompare;
    }

    public String getWord() {
        return word;
    }

    public ArrayList<String> getWordsForCompare() {
        return wordsForCompare;
    }
}
