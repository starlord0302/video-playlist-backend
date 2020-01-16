package com.starlord0302.videoplaylist.services;

import com.starlord0302.videoplaylist.models.Playlist;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PlaylistService {
    public Optional<Playlist> getPlaylist(Long id);
    public Playlist savePlaylist(Playlist playlist);
}
