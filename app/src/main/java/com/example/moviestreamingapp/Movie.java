package com.example.moviestreamingapp;

public class Movie {
    private String id;
    private String title;
    private String posterUrl;
    private int position;
    private String youtubeId; // Stores YouTube video ID (e.g., "dQw4w9WgXcQ")

    public Movie(String id, String title, String posterUrl, int position, String youtubeId) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.position = position;
        this.youtubeId = youtubeId;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterUrl() { return posterUrl; }
    public int getPosition() { return position; }
    public String getYoutubeId() { return youtubeId; }
}