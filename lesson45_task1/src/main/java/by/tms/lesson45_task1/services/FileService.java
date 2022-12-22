package by.tms.lesson45_task1.services;

import by.tms.lesson45_task1.dto.UploadResult;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface FileService {

    UploadResult upload(MultipartFile file);
    Path load(String filename);
    Resource loadAsResource(String filename);
}
