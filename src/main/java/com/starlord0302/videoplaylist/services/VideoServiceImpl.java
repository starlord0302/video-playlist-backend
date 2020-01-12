package com.starlord0302.videoplaylist.services;

import com.starlord0302.videoplaylist.models.Video;
import com.starlord0302.videoplaylist.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
