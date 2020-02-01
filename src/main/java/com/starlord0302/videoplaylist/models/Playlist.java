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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "playlist_video",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private List<Video> videos;

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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    /*
    public void addPlaylistVideo(PlaylistVideo playlistVideo) {
        playlists.add(playlistVideo);
        playlistVideo.setPlaylist(this);
    }

    public void removePlaylistVideo(PlaylistVideo playlistVideo) {
        playlists.remove(playlistVideo);
        playlistVideo.setPlaylist(null);
    }*/
}
