package com.starlord0302.videoplaylist.repositories;

import com.starlord0302.videoplaylist.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}