package com.danila.anagram.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnagramChecking {
    public Map<String, Boolean> compereWithWord(String word, List<String> inputData){
        Map<String, Boolean> data = new HashMap<>();
        for (String item : inputData){
            boolean status = false;
            if (new StringBuilder(word.replace(" ", "")).reverse().toString().equals(item.replace(" ", ""))){
                status = true;
            }
            data.put(item, status);
        }
        return data;
    }
}
