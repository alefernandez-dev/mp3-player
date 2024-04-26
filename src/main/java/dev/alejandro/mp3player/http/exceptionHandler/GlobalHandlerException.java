package dev.alejandro.mp3player.http.exceptionHandler;

import dev.alejandro.mp3player.service.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalHandlerException {


    private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

    @ExceptionHandler({
            InvalidExtensionException.class,
            FileReadException.class,
            FileWriteException.class,
            FileNotFoundException.class,
            FileDeleteException.class})
    public ResponseEntity<ErrorResponse> handleAppException(Exception e) {
        logger.error(e.getMessage(), e.getCause());
        return ResponseEntity.internalServerError().body(ErrorResponse.of(e.getMessage()));
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException(IOException e) {
        logger.error(e.getMessage(), e.getCause());
        return ResponseEntity.internalServerError().body(ErrorResponse.of("IO error"));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        logger.error(e.getMessage(), e.getCause());
        return ResponseEntity.internalServerError().body(ErrorResponse.of("unexpected error"));
    }

}
