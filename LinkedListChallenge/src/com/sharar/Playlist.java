package com.sharar;

import java.util.ArrayList;
import java.util.LinkedList;


public class Playlist {
    private String playListName;
    private LinkedList<Song> playlist;
    private ArrayList<Album> albums;

    //playlist can only add songs already added to an album
    //songs in the playlist will appear in the order they're added
    //so you can only load into the linkedlist from the arraylist.

    public Playlist(String playListName) {
        this.playListName = playListName;
        this.playlist = new LinkedList<>();
        this.albums = new ArrayList<>();
    }


    // TODO: 8/18/16 add this
    public void addSongToPlaylist(String albumName, String songName) {
        Album album = getAlbum(albumName);
        Song song = album.getSongFromAlbum(songName);
        if ((album == null) || (song == null)) {
            System.out.println("The album or song does not exist");
        } else this.playlist.add(song);
    }

    // TODO: 8/18/16 add this
    public void removeSongFromPlaylist(String songName) {
        if (findSong(songName) >= 0) {
            this.playlist.remove(findSong(songName));
        } else System.out.println("Song " + songName + " not found");
    }


    // TODO: 8/18/16 add this
    public void createAlbum(String albumName) {
        if (findAlbum(albumName) < 0)
            albums.add(new Album(albumName));
        else System.out.println("Album already exists");
    }

    // TODO: 8/18/16 add this
    public void deleteAlbum(String albumName) {
        if (findAlbum(albumName) >= 0) {
            albums.remove(findAlbum(albumName));
        } else System.out.println("Album not found");
    }

    // TODO: 8/18/16 add this
    public void addSongToAlbum(String albumName, String songName, int duration) {
        if (findAlbum(albumName) >= 0) {
            albums.get(findAlbum(albumName)).addSongToAlbum(songName, duration);
        } else System.out.println("Album not found, please create it");
    }

    // TODO: 8/18/16 add this
    public void removeSongFromAlbum(String albumName, String songName) {
        if (findAlbum(albumName) >= 0) {
            albums.get(findAlbum(albumName)).removeSongFromAlbum(songName);
        } else System.out.println("Album not found");
    }

    // TODO: 8/18/16 add this
    public void listAlbums(boolean listSongs) {
        String text = "Here is a list of all your albums";
        if (listSongs) text += " and their songs";
        System.out.println(text);
        for (int i = 0; i < albums.size(); i++) {
            if (!albums.isEmpty()) {
                if (!listSongs) {
                    System.out.println(albums.get(i).getAlbumName());
                } else {
                    System.out.println(albums.get(i).getAlbumName());
                    if (!albums.get(i).getAlbumArray().isEmpty())
                        albums.get(i).listSongs();
                    else System.out.println("no songs in album");
                }
            } else {
                System.out.println("empty");
            }
        }
    }

    //////////////not called by user directly :::::::

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    private int findSong(String name) {
        for (int i = 0; i < this.playlist.size(); i++) {
            String songTitle = playlist.get(i).getTitle();
            if (songTitle.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private Album getAlbum(String albumName) {
        if (findAlbum(albumName) >= 0) {
            return albums.get(findAlbum(albumName));
        } else return null;
    }

    private int findAlbum(String name) {
        for (int i = 0; i < this.albums.size(); i++) {
            String albumTitle = albums.get(i).getAlbumName();
            if (albumTitle.equals(name)) {
                return i;
            }
        }
        return -1;
    }

}
