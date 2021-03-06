package com.starlord0302.videoplaylist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @Column(name = "video_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private int length;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "videos")
    @JsonIgnore
    private List<Playlist> playlists;

    public Video() {
    }

    public Video(String title, int length, String description) {
        this.title = title;
        this.length = length;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    /*
    public void addPlaylistVideo(PlaylistVideo playlistVideo) {
        playlists.add(playlistVideo);
        playlistVideo.setVideo(this);
    }

    public void removePlaylistVideo(PlaylistVideo playlistVideo) {
        playlists.remove(playlistVideo);
        playlistVideo.setVideo(null);
    }*/
}
