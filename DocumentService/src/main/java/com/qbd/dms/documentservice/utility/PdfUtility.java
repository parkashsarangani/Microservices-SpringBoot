package com.qbd.dms.documentservice.utility;

import com.qbd.dms.documentservice.entities.Document;
import com.qbd.dms.documentservice.repos.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class PdfUtility {


    @Autowired
    DocumentRepo documentRepo;
    public static final String STORAGE_ROOT_DIRECTORY = "C:\\uploads\\";

    public String savePDF(MultipartFile file) throws IOException {
        try {
            String filePath = STORAGE_ROOT_DIRECTORY + file.getOriginalFilename();
            file.transferTo(new File(filePath));
        } catch (Exception exception) {
            return "Couldn't saved PDF due to: " + exception.getMessage();
        }
        return "PDF have been saved!";
    }

    public String deletePDF(Long id) throws IOException {
        try {
            Document document = documentRepo.findById(id).orElse(null);
            String filePath = STORAGE_ROOT_DIRECTORY + document.getName();
            File file1 = new File(filePath);
            file1.delete();
        } catch (Exception exception) {
            return "Couldn't delete PDF due to: " + exception.getMessage();
        }
        return "PDF have been deleted!";
    }

}
