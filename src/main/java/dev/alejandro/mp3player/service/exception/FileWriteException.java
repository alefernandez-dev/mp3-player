package dev.alejandro.mp3player.service.exception;

public class FileWriteException extends Exception{

    private static final String DEFAULT_MESSAGE = "error writing file";

    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public static FileWriteException cause(Throwable cause) {
        return new FileWriteException(DEFAULT_MESSAGE, cause);
    }
}
