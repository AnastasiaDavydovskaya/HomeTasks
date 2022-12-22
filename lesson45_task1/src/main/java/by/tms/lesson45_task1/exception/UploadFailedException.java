package by.tms.lesson45_task1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UploadFailedException extends RuntimeException {

    public UploadFailedException(String message) {
        super(message);
    }
}
