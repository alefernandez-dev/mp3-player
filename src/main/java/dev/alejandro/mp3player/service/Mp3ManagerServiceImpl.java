package dev.alejandro.mp3player.service;

import dev.alejandro.mp3player.service.exception.*;
import dev.alejandro.mp3player.service.validator.mp3.Mp3Validator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

public class Mp3ManagerServiceImpl implements Mp3ManagerService{

    private final String musicDirectory;

    public Mp3ManagerServiceImpl() {
        this.musicDirectory = System.getenv("MUSIC_DIRECTORY");
    }

    @Override
    public void saveMusic(InputStream inputStream, String fileName) throws FileWriteException, InvalidExtensionException {
        if(!Mp3Validator.validate(fileName)) {
            throw InvalidExtensionException.throwException();
        }
        try {
            var destination = Path.of(musicDirectory, fileName);
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw FileWriteException.cause(e);
        }
    }

    @Override
    public Result<List<String>> getMusicList() {
        var folder = new File(musicDirectory);
        if (!folder.exists() || !folder.isDirectory()) {
            return Result.failure("music folder does not exist or is not a valid directory");
        }
        var files = folder.listFiles();
        if (files == null) {
            return Result.failure("unable to retrieve the list of files from the folder");
        }
        var list = Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .filter(Mp3Validator::validate)
                .toList();
        return Result.success(list);
    }

    @Override
    public void deleteMusic(String fileName) throws FileNotFoundException {
        var musicFile = new File(musicDirectory + "/" + fileName);
        if (!musicFile.exists()) {
            throw FileNotFoundException.throwException();
        }
        if(!musicFile.delete()) {
            throw FileDeleteException.throwException();
        }
    }

    @Override
    public byte[] getMusicResource(String fileName) throws FileReadException {
        var filePath = Paths.get(musicDirectory, fileName);
        byte[] audioBytes;
        try {
            audioBytes = Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw FileReadException.cause(e);
        }
        return audioBytes;
    }
}
