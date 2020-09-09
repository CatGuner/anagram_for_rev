package com.danila.anagram;

import com.danila.anagram.model.InputData;
import com.danila.anagram.service.AnagramChecking;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AnagramApplicationTests {

    AnagramChecking anagramChecking;

    InputData inputData;

    @BeforeEach
    void setup() {
        ArrayList<String> s = new ArrayList<>();
        anagramChecking = new AnagramChecking();
        s.add("111");
        s.add("      q \t   w e");
        s.add("qwe");
        inputData = new InputData("ewq", s);
    }

    @Test
    @DisplayName("Testing AnagramCheching.class")
    public void testAnagramChecking() {
        Map<String, Boolean> rightAnsw = new HashMap<>();
        rightAnsw.put("111", false);
        rightAnsw.put("      q \t   w e", false);
        rightAnsw.put("qwe", true);
        Assert.assertEquals(anagramChecking.compereWithWord(inputData.getWord(), inputData.getWordsForCompare()), rightAnsw);
    }




}
