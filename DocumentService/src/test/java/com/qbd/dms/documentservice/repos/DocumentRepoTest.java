package com.qbd.dms.documentservice.repos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qbd.dms.documentservice.controllers.DocumentController;
import com.qbd.dms.documentservice.entities.Document;
import com.qbd.dms.documentservice.services.DocumentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class DocumentRepoTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    DocumentController documentController;

    @MockBean
    DocumentService documentService;

    @MockBean
    DocumentRepo documentRepo;

    Document RECORD_1 = new Document(1L, "Cover Letter.pdf", 1L);
    Document RECORD_2 = new Document(2L, "Resume.pdf", 1L);
    Document RECORD_3 = new Document(3L, "Degree.pdf", 1L);

    @Test
    public void getAllRecords_success() throws Exception {

        List<Document> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
        Mockito.when(documentRepo.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/document/viewAllFiles").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(records);
                });
    }
}
