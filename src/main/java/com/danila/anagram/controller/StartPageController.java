package com.danila.anagram.controller;

import com.danila.anagram.model.InputData;
import com.danila.anagram.service.AnagramChecking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Deque;
import java.util.HashMap;

@RestController
public class StartPageController {

    public StartPageController(){}

    @PostMapping(path = "/anagram")
    public HashMap<String,String> chekData(@RequestBody InputData data){
        return AnagramChecking.compereWithWord(data.getWord(), data.getWordsForCompare());
    }

}