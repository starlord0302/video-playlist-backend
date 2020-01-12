package com.starlord0302.videoplaylist.controllers;

import com.starlord0302.videoplaylist.models.Video;
import com.starlord0302.videoplaylist.services.VideoService;
import com.starlord0302.videoplaylist.services.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("")
    public ResponseEntity<Iterable<Video>> getAll() {
        return new ResponseEntity<>(videoService.getAllVideos(), HttpStatus.OK);
    }
}
