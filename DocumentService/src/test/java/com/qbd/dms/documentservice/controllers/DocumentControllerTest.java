package com.qbd.dms.documentservice.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DocumentController.class)
@ExtendWith(SpringExtension.class)
public class DocumentControllerTest {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    DocumentController documentController;

    @Test
    public void getAllDocumentsAPI() throws Exception {

        MockMultipartFile mockMultipartFile = new MockMultipartFile("", "", "", "".getBytes());
        String response = documentController.uploadFile(mockMultipartFile);
        Assertions.assertTrue(response.equalsIgnoreCase(""));
    }

}
