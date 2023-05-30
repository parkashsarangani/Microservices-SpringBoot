package com.qbd.dms.documentservice.controllers;

import com.qbd.dms.documentservice.entities.Document;
import com.qbd.dms.documentservice.exceptions.FileExtensionException;
import com.qbd.dms.documentservice.services.DocumentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    public DocumentService documentService;

    private static final String extensionAllowed = "PDF";


    @PostMapping(value = "/uploadDocument", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadDocument(@RequestPart(value = "document", required = true) MultipartFile document) throws IOException {

        String uploadedFileExtension = StringUtils.getFilenameExtension(document.getOriginalFilename());
        if (extensionAllowed.equalsIgnoreCase(uploadedFileExtension)) {
            String result = documentService.saveFile(document);
            logger.info("Document save request result: " + result);
            return result;
        } else {
            throw new FileExtensionException();
        }
    }

    @PutMapping(value = "/updateDocument/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateDocument(@RequestPart(value = "document", required = true) MultipartFile file, @PathVariable String id) throws IOException {

        return documentService.updateFile(file, Long.parseLong(id));
    }

    @DeleteMapping(value = "/deleteDocument/{id}")
    public String deleteDocument(@PathVariable String id) throws IOException {
        return documentService.deleteFile(Long.parseLong(id));
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<?> getDocument(@PathVariable String id) throws IOException {
        return documentService.getFile(Long.parseLong(id));
    }

    @GetMapping(value = "/viewDocument/{id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> viewDocument(@PathVariable String id) throws IOException {
        return documentService.viewFile(Long.parseLong(id));
    }

    @GetMapping(value = "/viewAllDocuments")
    public ResponseEntity<?> viewAllDocuments() {
        return new ResponseEntity<>(documentService.viewAllFiles(1), HttpStatus.OK);
    }

}
