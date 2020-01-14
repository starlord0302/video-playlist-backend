package com.starlord0302.videoplaylist.services;

import com.starlord0302.videoplaylist.models.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    public List<Video> getAllVideos();
    public Optional<Video> getVideo(Long id);
    public Video saveVideo(Video video);
    public boolean findVideo(Video video);
    public void deleteById(Long id);
}
