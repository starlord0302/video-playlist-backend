package com.starlord0302.videoplaylist.models;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "video")
    private List<PlaylistVideo> playlists;

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

    public List<PlaylistVideo> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistVideo> playlists) {
        this.playlists = playlists;
    }
}
