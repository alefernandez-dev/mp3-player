package dev.alejandro.mp3player.service;

import java.io.Serializable;

public record Result<T>(T result, boolean success, String message) implements Serializable {
    public static <T> Result<T> success(T result) {
        return new Result<>(result, true, "success");
    }

    public static <T> Result<T> failure(String message) {
        return new Result<>(null, false, message);
    }
}
