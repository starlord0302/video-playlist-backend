package com.starlord0302.videoplaylist.controllers;

import com.starlord0302.videoplaylist.models.Playlist;
import com.starlord0302.videoplaylist.models.PlaylistVideo;
import com.starlord0302.videoplaylist.repositories.PlaylistRepository;
import com.starlord0302.videoplaylist.repositories.PlaylistVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/playlist")
public class PlaylistVideoController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("")
    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }
}
