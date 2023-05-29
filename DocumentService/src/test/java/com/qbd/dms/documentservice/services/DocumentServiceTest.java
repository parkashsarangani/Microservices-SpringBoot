package com.qbd.dms.documentservice.services;


import com.qbd.dms.documentservice.utility.PdfUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;

public class DocumentServiceTest {

    @MockBean
    PdfUtility pdfUtility;


    @Test
    @DisplayName("always true")
    public void test() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("NullPointerException case")
    public void testSaveFile() throws IOException {
        DocumentService documentService = new DocumentService();
        Assertions.assertThrowsExactly(NullPointerException.class,() -> documentService.saveFile(null));
    }
}
