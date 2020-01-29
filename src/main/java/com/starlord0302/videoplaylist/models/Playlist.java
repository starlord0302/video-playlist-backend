package com.starlord0302.videoplaylist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "playlist_name")
    private String playlistName;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "playlist")
    private List<PlaylistVideo> playlists;

    public Playlist() {
    }

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<PlaylistVideo> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistVideo> playlists) {
        this.playlists = playlists;
    }

    public void addPlaylistVideo(PlaylistVideo playlistVideo) {
        playlists.add(playlistVideo);
        playlistVideo.setPlaylist(this);
    }

    public void removePlaylistVideo(PlaylistVideo playlistVideo) {
        playlists.remove(playlistVideo);
        playlistVideo.setPlaylist(null);
    }
}
