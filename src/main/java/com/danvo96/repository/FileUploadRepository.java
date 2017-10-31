package com.danvo96.repository;

import com.danvo96.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 10/31/2017.
 */
public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
}
