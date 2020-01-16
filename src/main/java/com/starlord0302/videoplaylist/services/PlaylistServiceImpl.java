package com.starlord0302.videoplaylist.services;

import com.starlord0302.videoplaylist.models.Playlist;
import com.starlord0302.videoplaylist.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Optional<Playlist> getPlaylist(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
