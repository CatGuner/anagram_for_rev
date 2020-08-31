package com.danila.anagram.service;

import java.util.ArrayList;
import java.util.HashMap;

public class AnagramChecking {
    public static HashMap<String, String> compereWithWord(String word, ArrayList<String> inputData){
        HashMap<String, String> data = new HashMap<>();
        for (String item : inputData){
            String status = "no";
            if (new StringBuilder(word.replace(" ", "")).reverse().toString().equals(item.replace(" ", ""))){
                status = "yes";
            }
            data.put(item, status);
        }
        return data;
    }
}
