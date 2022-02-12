package com.lyricfinder.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false)
    private String artist_name;
    @NotNull
    @Column(nullable = false)
    private String album_name;
    @NotNull
    @Column(nullable = false)
    private float rate;

    @NotNull
    @Column(nullable = false)
    private String lyrics;


    public Track(int id, String name, String artist_name, String album_name, float rate, String lyrics) {
        this.id = id;
        this.name = name;
        this.artist_name = artist_name;
        this.album_name = album_name;
        this.rate = rate;
        this.lyrics = lyrics;
    }

    public Track() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
