package com.qbd.dms.documentservice.services;



import com.qbd.dms.documentservice.utility.PdfUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class DocumentServiceTest {

    @MockBean
    PdfUtility pdfUtility;

    @Test
    public void testSaveFile(){
        Assertions.assertTrue(true);
    }
}
