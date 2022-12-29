package by.tms.lesson47_task2.services;

import by.tms.lesson47_task2.entities.File;
import by.tms.lesson47_task2.exceptions.UploadFailedException;
import by.tms.lesson47_task2.repositories.FileRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class FileService {

    private FileRepository fileRepository;
    private final Path RELATIVE_PATH = Path.of("./lesson47_task2");

    public void upload(MultipartFile file, Long id) {
        fileRepository.save(File.builder()
                .fileName(file.getOriginalFilename())
                .idTask(id)
                .build());

        Path destinationFile = RELATIVE_PATH.resolve(
                        Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new UploadFailedException(String.format("Cannot upload file: %s", e.getMessage()));
        }

    }


    public Path load(String filename) {
        return RELATIVE_PATH.resolve(filename);
    }

    public Resource loadAsResource(Long id) {
        String filename = fileRepository.findByIdTask(id).getFileName();
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new UploadFailedException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new UploadFailedException("Could not read file: " + filename);
        }
    }
}
