package com.danvo96.service;

import com.danvo96.entity.FileUpload;

import java.util.List;

/**
 * Created by Administrator on 10/31/2017.
 */
public interface FileUploadService {
    List<FileUpload> getAllFileUploaded();

    FileUpload getFileUploadById(Long id);

    FileUpload saveFileUpload(FileUpload fileUpload);
}
