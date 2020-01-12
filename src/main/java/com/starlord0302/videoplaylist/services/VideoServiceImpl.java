package com.starlord0302.videoplaylist.services;

import com.starlord0302.videoplaylist.models.Video;
import com.starlord0302.videoplaylist.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> getVideo(Long id) {
        return videoRepository.findById(id);
    }

    @Override
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public boolean isVideoExists(Video video) {
        return getVideo(video.getId()).isPresent();
    }
}
