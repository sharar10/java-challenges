package com.sharar;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sharararzukrahman on 8/19/16.
 */
public class Album {
    private String name;
    private String artist;
    // private ArrayList<Song> songs;
    private SongList songs = new SongList();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        //this is 'foreach'. equivalent of fori. this checks through all the songs
        //java will create a variable called checkSong for every Song in the songs arraylist.

        for (Song checkedSong : this.songs.getSongs()) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index < this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    //apparently you can have the same number of arguments being passed in. just the types have to be different. this changes everything.
    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This song " + title + " is not in this alum");
        return false;
    }


    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();

        }

        public ArrayList<Song> getSongs() {
            return songs;
        }

        private void add(Song song) {
            this.songs.add(song);
        }
        private Song get(int index) {
            return this.songs.get(index);
        }
        private int size() {
            return this.songs.size();
        }

    }


}
