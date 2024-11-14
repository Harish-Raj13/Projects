package com.harishraj.springsecuritydemo.controller;

import com.harishraj.springsecuritydemo.model.Video;
import com.harishraj.springsecuritydemo.service.VideoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllVideos());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/video/{id}")
    public ResponseEntity<ByteArrayResource> getVideo(@PathVariable Long id) {
        Optional<Video> videoOpt = videoService.getVideoById(id);
        if (videoOpt.isPresent()) {
            Video video = videoOpt.get();
            ByteArrayResource videoResource = new ByteArrayResource(video.getContent());  // Get video content as byte array
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(videoResource);  // Return the video resource in the response
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if the video doesn't exist
        }
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/video")
    public ResponseEntity<Video> uploadVideo(@RequestParam("file") MultipartFile file,
                                             @RequestParam("name") String name,
                                             @RequestParam("description") String description) throws IOException {
        // Debugging line
        System.out.println("Uploading video with name: " + name + " and description: " + description);

        byte[] content = file.getBytes();
        Video video = new Video(name, description, content);
        Video savedVideo = videoService.saveVideo(video);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedVideo);
    }



    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/video/{id}")
    public ResponseEntity<String> updateVideo(@PathVariable Long id,
                                              @RequestParam("file") MultipartFile file,
                                              @RequestParam("name") String name,
                                              @RequestParam("description") String description) throws IOException {
        Video video = new Video(name, description, file.getBytes());
        videoService.updateVideo(id, video);
        return ResponseEntity.ok("Video updated successfully.");
    }

    @DeleteMapping("/video/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long id) {
        try {
            videoService.deleteVideo(id);
            return ResponseEntity.ok("Video deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video not found.");
        }
    }

}
