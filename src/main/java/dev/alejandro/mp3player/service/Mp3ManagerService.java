package dev.alejandro.mp3player.service;

import dev.alejandro.mp3player.service.exception.*;

import java.io.InputStream;
import java.util.List;

public interface Mp3ManagerService {
    void saveMusic(InputStream inputStream, String fileName) throws FileWriteException, InvalidExtensionException;
    Result<List<String>> getMusicList();
    void deleteMusic(String fileName) throws FileNotFoundException, FileDeleteException;
    byte[] getMusicResource(String fileName) throws FileReadException;
}
