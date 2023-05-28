package com.qdb.dms.integration.postintegrationservice.external.services;

import com.qdb.dms.integration.postintegrationservice.external.models.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(value = "documentService", url = "localhost:8081/api/document/")
public interface DocumentServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getFile/{id}")
    Document getDocument(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/viewAllFiles")
    List<Document> getAllDocuments();
}
