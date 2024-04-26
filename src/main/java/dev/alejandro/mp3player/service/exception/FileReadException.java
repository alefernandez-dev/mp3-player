package dev.alejandro.mp3player.service.exception;

public class FileReadException extends Exception{

    private static final String DEFAULT_MESSAGE = "error reading file";

    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
    public static FileReadException cause(Throwable cause) {
        return new FileReadException(DEFAULT_MESSAGE, cause);
    }

}
