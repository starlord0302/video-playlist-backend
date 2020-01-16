package com.starlord0302.videoplaylist.models;

import javax.persistence.*;

@Entity
@Table(name = "playlists")
public class PlayList {

    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "playlist_name")
    private String playlistName;

    public PlayList() {
    }

    public PlayList(String playlistName) {
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
}
