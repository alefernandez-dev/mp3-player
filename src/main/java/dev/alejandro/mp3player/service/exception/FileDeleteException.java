package dev.alejandro.mp3player.service.exception;

public class FileDeleteException extends Exception{

    private final static String DEFAULT_MESSAGE = "error deleting file";

    public FileDeleteException(String message) {
        super(message);
    }

    public static FileNotFoundException throwException() {
        return new FileNotFoundException(DEFAULT_MESSAGE);
    }
}
