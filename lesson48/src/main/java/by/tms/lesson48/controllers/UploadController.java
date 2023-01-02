package by.tms.lesson48.controllers;

import by.tms.lesson48.services.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
@AllArgsConstructor
@Slf4j
public class UploadController {

    private FileService fileService;

    @PostMapping("/{id}")
    public String upload(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        fileService.upload(file, id);

        return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> serveFile(@PathVariable Long id) {
        Resource file = fileService.loadAsResource(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
