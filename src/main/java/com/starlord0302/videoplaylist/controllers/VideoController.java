package com.starlord0302.videoplaylist.controllers;

import com.starlord0302.videoplaylist.models.Video;
import com.starlord0302.videoplaylist.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
