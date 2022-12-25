package by.tms.lesson46_task1.services;

import by.tms.lesson46_task1.dto.UploadResult;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileService {

    UploadResult upload(MultipartFile file);
    Path load(String filename);
    Resource loadAsResource(String filename);
}
