package dev.alejandro.mp3player.http.exceptionHandler;

import java.io.Serializable;

public record ErrorResponse(String message) implements Serializable {
    public static ErrorResponse of(String message) {
        return new ErrorResponse(message);
    }
}
