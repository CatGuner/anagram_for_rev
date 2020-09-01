package com.danila.anagram.controller;

import com.danila.anagram.model.InputData;
import com.danila.anagram.service.AnagramChecking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class StartPageController {

    @Autowired
    AnagramChecking anagramChecking;

    @PostMapping(path = "/anagram")
    public Map<String, Boolean> chekData(@RequestBody InputData data){
        return anagramChecking.compereWithWord(data.getWord(), data.getWordsForCompare());
    }

}