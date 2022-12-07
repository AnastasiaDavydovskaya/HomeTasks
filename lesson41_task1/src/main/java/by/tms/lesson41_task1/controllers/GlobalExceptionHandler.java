package by.tms.lesson41_task1.controllers;

import by.tms.lesson41_task1.exceptions.NotFoundStudents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundStudents.class)
    public String notFoundStudents(HttpServletRequest request, Exception e) {
        log.error("Exception occurred while calling {}: {}", request.getRequestURI(), e.getMessage());
        return "index";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound(HttpServletRequest request, NoHandlerFoundException e) {
        log.error("Exception occurred while calling {}: {}", request.getRequestURI(), e.getMessage());
        return "404";
    }
}
