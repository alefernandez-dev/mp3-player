package dev.alejandro.mp3player.service.validator.mp3;

public class Mp3Validator {
    public static boolean validate(String fileName) {
        String extensionPattern = "^.+\\.(?i)(mp3)$";
        return fileName != null && fileName.matches(extensionPattern);
    }
}
