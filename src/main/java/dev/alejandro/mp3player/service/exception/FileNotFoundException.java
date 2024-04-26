package dev.alejandro.mp3player.service.exception;

public class FileNotFoundException extends Exception{

    private static final String DEFAULT_MESSAGE = "file not found";

    public FileNotFoundException(String message) {
        super(message);
    }

    public static FileNotFoundException throwException() {
        return new FileNotFoundException(DEFAULT_MESSAGE);
    }
}
