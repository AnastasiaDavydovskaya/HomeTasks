package by.tms.lesson45_task1.services;

import by.tms.lesson45_task1.dto.UploadResult;
import by.tms.lesson45_task1.exception.UploadFailedException;
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

    private static final Path RELATIVE_PATH = Path.of("./lesson45_task1");

    @Override
    public UploadResult upload(MultipartFile file) {
        Path destinationFile = RELATIVE_PATH.resolve(
                        Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();

        try(InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new UploadFailedException(String.format("Cannot upload file: %s", e.getMessage()));
        }

        return UploadResult.builder().message("Uploaded successfully").build();
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
