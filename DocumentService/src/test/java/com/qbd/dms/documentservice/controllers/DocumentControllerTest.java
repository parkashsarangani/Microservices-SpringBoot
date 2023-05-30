package com.qbd.dms.documentservice.controllers;

import com.qbd.dms.documentservice.DocumentServiceApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = DocumentServiceApp.class)
@AutoConfigureMockMvc
public class DocumentControllerTest {

    @Autowired
    DocumentController documentController;

    @Test
    @DisplayName("Success case to uploadDocument")
    public void uploadDocumentSuccess() throws Exception {

        MockMultipartFile mockMultipartFile = new MockMultipartFile("hello.pdf", "hello.pdf", MediaType.APPLICATION_PDF_VALUE, "Hello, World!".getBytes());
        String response = documentController.uploadDocument(mockMultipartFile);

        Assertions.assertTrue(response.equalsIgnoreCase("PDF have been saved!"));
    }

    @Test
    @DisplayName("Success case for getAllDocuments statusCode")
    public void getAllDocumentsAPIStatusCodeSuccess() {

        ResponseEntity<?> response = documentController.viewAllDocuments();
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

}
