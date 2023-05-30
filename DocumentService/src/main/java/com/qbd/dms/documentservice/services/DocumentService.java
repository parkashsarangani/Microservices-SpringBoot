package com.qbd.dms.documentservice.services;

import com.qbd.dms.documentservice.entities.Document;
import com.qbd.dms.documentservice.repos.DocumentRepo;
import com.qbd.dms.documentservice.utility.PdfUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    PdfUtility pdfUtility;

    @Autowired
    DocumentRepo documentRepo;

    public String saveFile(MultipartFile file) throws IOException {

        if(file == null) {
            throw new NullPointerException();
        }

        Document document = new Document();
        document.setName(file.getOriginalFilename());
        document.setUserId(1L);
        documentRepo.save(document);
        return pdfUtility.savePDF(file);

    }

    public String updateFile(MultipartFile file, Long id) throws IOException {

        Document document = new Document();
        document.setId(id);
        document.setName(file.getOriginalFilename());
        document.setUserId(1L);
        documentRepo.save(document);
        pdfUtility.deletePDF(id);
        return pdfUtility.savePDF(file);
    }

    public String deleteFile(Long id) throws IOException {
        String response  = pdfUtility.deletePDF(id);
        documentRepo.deleteById(id);
        return response;
    }

    public ResponseEntity<?> viewFile(Long id) throws IOException {

        Document document = documentRepo.findById(id).orElse(new Document());
        if (document.getId() == null) {
            return new ResponseEntity<>("File doesn't exist!", HttpStatus.OK);
        } else {
            File file = new File(PdfUtility.STORAGE_ROOT_DIRECTORY + document.getName());
            return new ResponseEntity<>(new FileSystemResource(file), HttpStatus.OK);
        }
    }
    public ResponseEntity<?> getFile(Long id) throws IOException {

        Document document = documentRepo.findById(id).orElse(new Document());
        if (document.getId() == null) {
            return new ResponseEntity<>("File doesn't exist!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(document, HttpStatus.OK);
        }
    }

    public List<Document> viewAllFiles(long userId) {
        return documentRepo.findAllByUserId(userId);
    }
}
