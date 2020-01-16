package com.starlord0302.videoplaylist.models;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "playlist")
    private List<PlaylistVideo> playLists;

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

    public List<PlaylistVideo> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlaylistVideo> playLists) {
        this.playLists = playLists;
    }
}
