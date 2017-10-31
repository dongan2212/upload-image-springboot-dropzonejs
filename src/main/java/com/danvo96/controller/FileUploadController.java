package com.danvo96.controller;

import com.danvo96.entity.FileUpload;
import com.danvo96.service.FileUploadService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 10/31/2017.
 */
@Controller
@RequestMapping("/v1/api/uploadFile")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    private static String UPLOADED_FOLDER = "D:\\Aptech\\JavaSem4\\upload-image-spring-db-dropzone\\src\\main\\resources\\image\\";


    @GetMapping()
    public String home() {
        return "fileUploader";
    }

    @PostMapping(value = "/upload")
    public List<FileUpload> uploadMultiFiles(MultipartHttpServletRequest request,
                                      HttpServletResponse response) throws IOException {

        // Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        // Iterate through the map
        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            saveFileToLocalDisk(multipartFile);

            FileUpload fileInfo = getFileUploadInfo(multipartFile);

            // Save the file info to database
            fileInfo = saveFileToDatabase(fileInfo);

            // adding the file info to the list
            uploadedFiles.add(fileInfo);
        }

        return uploadedFiles;
    }


    @RequestMapping(value = {"/list"})
    public String listFiles(Map<String, Object> map) {
        map.put("fileList", fileUploadService.getAllFileUploaded());
        return "/listFiles";
    }

    @RequestMapping(value = "/get/{fileId}", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response, @PathVariable Long fileId) {

        FileUpload dataFile = fileUploadService.getFileUploadById(fileId);

        File file = new File(dataFile.getLocation(), dataFile.getName());

        try {
            response.setContentType(dataFile.getType());
            response.setHeader("Content-disposition", "attachment; filename=\"" + dataFile.getName()
                    + "\"");

            FileCopyUtils.copy(FileUtils.readFileToByteArray(file), response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveFileToLocalDisk(MultipartFile multipartFile) throws IOException {
        String outputFileName = UPLOADED_FOLDER + multipartFile.getOriginalFilename();
        FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(outputFileName));
    }

    private FileUpload saveFileToDatabase(FileUpload uploadedFile) {
        return fileUploadService.saveFileUpload(uploadedFile);
    }


    private FileUpload getFileUploadInfo(MultipartFile multipartFile) throws IOException {
        FileUpload fileInfo = new FileUpload();
        fileInfo.setName(multipartFile.getOriginalFilename());
        fileInfo.setSize(multipartFile.getSize());
        fileInfo.setType(multipartFile.getContentType());
        fileInfo.setLocation(UPLOADED_FOLDER);
        return fileInfo;
    }
}
