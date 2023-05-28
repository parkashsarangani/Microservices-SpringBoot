package com.qbd.dms.documentservice.utility;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class PdfUtility {

    public static final String STORAGE_ROOT_DIRECTORY = "E:\\uploads\\";

    public String savePDF(MultipartFile file) throws IOException {
        try {
            String filePath = STORAGE_ROOT_DIRECTORY + file.getOriginalFilename();
            file.transferTo(new File(filePath));
        }catch (Exception exception){
            return "Couldn't saved PDF due to: " + exception.getMessage();
        }
        return "PDF have been saved!";
    }
}
