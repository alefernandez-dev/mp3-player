package dev.alejandro.mp3player.service;

import dev.alejandro.mp3player.service.exception.FileNotFoundException;
import dev.alejandro.mp3player.service.exception.FileReadException;
import dev.alejandro.mp3player.service.exception.FileWriteException;
import dev.alejandro.mp3player.service.exception.InvalidExtensionException;

import java.io.InputStream;
import java.util.List;

public interface Mp3ManagerService {
    void saveMusic(InputStream inputStream, String fileName) throws FileWriteException, InvalidExtensionException;
    Result<List<String>> getMusicList();
    void deleteMusic(String fileName) throws FileNotFoundException;
    byte[] getMusicResource(String fileName) throws FileReadException;
}
