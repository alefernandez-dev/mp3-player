package dev.alejandro.mp3player.service.exception;

public class InvalidExtensionException extends Exception{

    private static final String DEFAULT_MESSAGE = "invalid file extension [allowed only mp3]";
    public InvalidExtensionException(String message) {
        super(message);
    }

    public static InvalidExtensionException throwException() {
        return new InvalidExtensionException(DEFAULT_MESSAGE);
    }
}
