package com.danvo96.service.impl;

import com.danvo96.entity.FileUpload;
import com.danvo96.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.danvo96.service.FileUploadService;

import java.util.List;

/**
 * Created by Administrator on 10/31/2017.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
//    @Transactional(readOnly = true)
    public List<FileUpload> getAllFileUploaded() {
        return fileUploadRepository.findAll();
    }

    @Override
//    @Transactional(readOnly = true)
    public FileUpload getFileUploadById(Long id) {
        return fileUploadRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = Exception.class)
    public FileUpload saveFileUpload(FileUpload fileUpload) {

        return fileUploadRepository.save(fileUpload);
    }
}
