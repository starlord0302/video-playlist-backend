package com.starlord0302.videoplaylist.repositories;

import com.starlord0302.videoplaylist.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Optional<Playlist> findByPlaylistName(String name);
}
