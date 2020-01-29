package com.starlord0302.videoplaylist.repositories;

import com.starlord0302.videoplaylist.models.PlaylistVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistVideoRepository extends JpaRepository<PlaylistVideo, Long> {
    List<PlaylistVideo> findByVideoId(Long videoId);
}
