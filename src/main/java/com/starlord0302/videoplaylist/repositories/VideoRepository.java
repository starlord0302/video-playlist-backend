package com.starlord0302.videoplaylist.repositories;

import com.starlord0302.videoplaylist.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Optional<Video> findByTitle(String title);
}
