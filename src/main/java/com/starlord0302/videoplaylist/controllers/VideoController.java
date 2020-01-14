package com.starlord0302.videoplaylist.controllers;

import com.starlord0302.videoplaylist.models.Video;
import com.starlord0302.videoplaylist.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("")
    public ResponseEntity<Iterable<Video>> getAll(@RequestHeader("Accept") String accept) {
        if(accept.equals("application/json")) {
            List<Video> videos = videoService.getAllVideos();
            if(videos.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                return new ResponseEntity<>(videoService.getAllVideos(), headers, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideo(@RequestHeader("Accept") String accept, @PathVariable Long id) {
        if(accept.equals("application/json")) {
            Optional<Video> video = videoService.getVideo(id);
            if(video.isPresent()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                return new ResponseEntity<>(video.get(), headers, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Video> post(@RequestHeader("Accept") String accept,
                                      @RequestHeader("Content-Type") String contentType,
                                      @RequestBody Video video) {
        if(accept.equals("application/json") && contentType.equals("application/json")) {
            if(videoService.findVideo(video)) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<>(videoService.saveVideo(video), headers, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> put(@RequestHeader("Accept") String accept,
                                     @RequestHeader("Content-Type") String contentType,
                                     @RequestBody Video video,
                                     @PathVariable Long id) {
        if(accept.equals("application/json") && contentType.equals("application/json")) {
            Optional<Video> oVideo = videoService.getVideo(id);
            if(oVideo.isPresent()) {
                video.setId(id);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                return new ResponseEntity<>(videoService.saveVideo(video), headers, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> delete(@RequestHeader("Accept") String accept, @PathVariable Long id) {
        if(accept.equals("application/json")) {
            Optional<Video> oVideo = videoService.getVideo(id);
            if(oVideo.isPresent()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                videoService.deleteById(id);
                return new ResponseEntity<>(oVideo.get(), headers, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
