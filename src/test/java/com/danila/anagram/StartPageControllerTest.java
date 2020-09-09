package com.danila.anagram;

import com.danila.anagram.controller.StartPageController;
import com.danila.anagram.model.InputData;
import com.danila.anagram.service.AnagramChecking;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StartPageController.class)
public class StartPageControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnagramChecking anagramCheckingService;

    private InputData inputData;

    @Test
    public void testPostResponseAnswer() throws Exception{
        inputData = new InputData("1", new ArrayList<>(Collections.singleton("1")));
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("1", true);

        when(anagramCheckingService.compereWithWord(any(), any())).thenReturn(response);


        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(post("/anagram")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputData)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(response)));

    }

}
