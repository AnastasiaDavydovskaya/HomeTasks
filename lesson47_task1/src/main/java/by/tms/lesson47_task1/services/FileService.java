package by.tms.lesson47_task1.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileService {

    void upload(MultipartFile file);
    Path load(String filename);
    Resource loadAsResource(String filename);
}
