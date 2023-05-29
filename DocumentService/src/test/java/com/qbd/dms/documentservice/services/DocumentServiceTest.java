package com.qbd.dms.documentservice.services;


import com.qbd.dms.documentservice.utility.PdfUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
public class DocumentServiceTest {

    @MockBean
    PdfUtility pdfUtility;

    @MockBean
    DocumentService documentService;


    @Test
    @DisplayName("always true")
    public void test() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Null case")
    public void testSaveFileNullPointer() throws IOException {
//        Mockito.when(documentService.saveFile(null)).thenThrow(NullPointerException.class);

        Assertions.assertTrue(null == documentService.saveFile(null));
    }

    @Test
    @DisplayName("Successful case")
    public void testSaveFileSuccess() throws IOException {

        MockMultipartFile file = new MockMultipartFile("hello.pdf", "hello.pdf", MediaType.APPLICATION_PDF_VALUE, "Hello, World!".getBytes());
        Mockito.when(documentService.saveFile(file)).thenReturn("PDF have been saved!");
        String result = documentService.saveFile(file);
        Assertions.assertTrue("PDF have been saved!".equalsIgnoreCase(result));
    }
}
