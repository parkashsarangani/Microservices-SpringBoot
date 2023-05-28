package com.qdb.dms.integration.postintegrationservice.services;

import com.qdb.dms.integration.postintegrationservice.entities.Post;
import com.qdb.dms.integration.postintegrationservice.external.models.Document;
import com.qdb.dms.integration.postintegrationservice.external.services.DocumentServiceClient;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.ConnectException;
import java.util.List;

@Service
public class IntegrationService {

    @Autowired
    DocumentServiceClient documentServiceClient;

    @Retry(name="getDocument", fallbackMethod = "getDocumentFallback")
    public Document viewDocument(Long documentId){
        return documentServiceClient.getDocument(documentId);
    }

    public List<Document> viewAllDocuments() {
        return documentServiceClient.getAllDocuments();
    }

    public Document getDocumentFallback(Throwable throwable) {
        System.out.println("INSIDE FALLBACK METHOD!");
        Document document = new Document();
        document.setId(100L);
        document.setName("Dummy document");
        document.setUserId(1L);
        return document;
    }

}
