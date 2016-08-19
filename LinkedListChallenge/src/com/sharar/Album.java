package com.sharar;

import java.util.ArrayList;


public class Album {
    private String albumName;
    private ArrayList<Song> album;

    public Album(String albumName) {
        this.albumName = albumName;
        this.album = new ArrayList<Song>();
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public Song getSongFromAlbum(String name) {
        int i = findSong(name);
        if (i >= 0) {
            return this.album.get(findSong(name));
        } else {
            System.out.println("Song does not exist");
            return null;
        }

    }

    public void addSongToAlbum(String name, int duration) {
        if (findSong(name) < 0)
            this.album.add(new Song(name, duration));
        else System.out.println("The song has already been added");
    }

    public void removeSongFromAlbum(String name) {
        int i = findSong(name);
        if (i >= 0) {
            this.album.remove(i);
        } else {
            System.out.println("Song cannot be found");
        }
    }

    private int findSong(String name) {
        for (int i = 0; i < this.album.size(); i++) {
            String songTitle = album.get(i).getTitle();
            if (songTitle.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Song> getAlbumArray() {
        return album;
    }

    public void listSongs() {
        for (int i = 0; i < this.album.size(); i++) {
            System.out.println(this.album.get(i).getTitle() + " " + this.album.get(i).getTime());
        }

    }


}
