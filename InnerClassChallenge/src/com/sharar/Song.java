package com.sharar;

/**
 * Created by sharararzukrahman on 8/19/16.
 */
public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    ///using toString
    @Override
    public String toString() {
        return this.title + " - " + this.duration;
    }
}

