package by.tms.lesson47_task1.services.impl;

import by.tms.lesson47_task1.exception.UploadFailedException;
import by.tms.lesson47_task1.services.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    private static final Path RELATIVE_PATH = Path.of("./lesson47_task1");

    @Override
    public void upload(MultipartFile file) {
        Path destinationFile = RELATIVE_PATH.resolve(
                        Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();

        try(InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new UploadFailedException(String.format("Cannot upload file: %s", e.getMessage()));
        }
    }

    @Override
    public Path load(String filename) {
        return RELATIVE_PATH.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new UploadFailedException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new UploadFailedException("Could not read file: " + filename);
        }
    }
}
