package dev.alejandro.mp3player.http;

import dev.alejandro.mp3player.service.*;
import dev.alejandro.mp3player.service.exception.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/music")
public class Mp3Controller {

    private final Mp3ManagerService managerService;

    public Mp3Controller(Mp3ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, FileWriteException, InvalidExtensionException {
        managerService.saveMusic(file.getInputStream(), file.getOriginalFilename());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Result<List<String>>> getMusicList() {
        return ResponseEntity.ok(managerService.getMusicList());
    }

    @GetMapping(value = "/play/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> playMusic(@PathVariable("fileName") String fileName) throws FileReadException {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(managerService.getMusicResource(fileName));
    }

    @DeleteMapping("/{fileName}")
    public ResponseEntity<?> deleteMusic(@PathVariable String fileName) throws FileNotFoundException, FileDeleteException {
        managerService.deleteMusic(fileName);
        return ResponseEntity.ok().build();
    }

}
