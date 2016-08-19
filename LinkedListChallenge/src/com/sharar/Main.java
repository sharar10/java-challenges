package com.sharar;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    /*functionality to implement through system in
     * quit, skip to next, skip to previous, replay current
     * list songs in the playlist
     * song must exist in album before it can be added to a playlist
     * remove current song from playlist (listiterator.remove())
     * remove song from album
     *
     */


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Playlist playlist = new Playlist("playlist");
        playlist.createAlbum("sharar");
        playlist.addSongToAlbum("sharar","damn",230);
        playlist.addSongToAlbum("sharar","vlad",230);
        playlist.addSongToAlbum("sharar","buga",230);
        playlist.addSongToAlbum("sharar","visa",230);
        playlist.addSongToPlaylist("sharar","damn");
        playlist.addSongToPlaylist("sharar","vlad");
        playlist.addSongToPlaylist("sharar","buga");
        playlist.addSongToPlaylist("sharar","visa");
        runPlaylist(playlist);
    }

    public static void runPlaylist(Playlist playlist) {
        System.out.println("Welcome to your playlist!");
        boolean quit = false;
        boolean goingForward = true;
        //playlist.getPlaylist() gets the linkedlist of the playlist, then you get the listIterator of the linkedlist
        ListIterator<Song> listIterator = playlist.getPlaylist().listIterator();
        LinkedList playlistLinkedList = playlist.getPlaylist();
        // TODO: 8/18/16 move this (below)
        if (playlistLinkedList.isEmpty()) {
            System.out.println("Please note there are no songs in the playlist");
        }
        printMenu();
        while (!quit) {
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (listIterator.hasPrevious() || listIterator.hasNext()) {
                        if (goingForward) {
                            listIterator.previous();
                            goingForward = true;

                            System.out.println("Now playing " + listIterator.next().getTitle() + " again");
                        } else {
                            listIterator.next();
                            goingForward = false;
                            System.out.println("Now playing " + listIterator.previous().getTitle() + " again");
                        }
                    } else System.out.println("Error occured, please add files");

                    break;
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 4:
                    System.out.println("Please enter the name of the album you wish to create");
                    String albumName = scanner.nextLine();
                    playlist.createAlbum(albumName);
                    break;
                case 5:
                    System.out.println("Add a song to an album \n please write the name of the album");
                    albumName = scanner.nextLine();
                    System.out.println("Please write the name of the song you wish to add to " + albumName);
                    String songName = scanner.nextLine();
                    System.out.println("How long is " + songName + "?");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    playlist.addSongToAlbum(albumName, songName, duration);
                    break;
                case 6:
                    System.out.println("Remove a song from an album + \n enter the name of the album to retrieve the song from");
                    albumName = scanner.nextLine();
                    System.out.println("Enter the name of the song you wish to delete from " + albumName);
                    songName = scanner.nextLine();
                    playlist.removeSongFromAlbum(albumName, songName);
                    break;
                case 7:
                    System.out.println("Add a song to your current playlist + \n enter the name of the album to retrieve the song from");
                    albumName = scanner.nextLine();
                    System.out.println("Enter the name of the song you wish to load from album " + albumName);
                    songName = scanner.nextLine();
                    playlist.addSongToPlaylist(albumName, songName);
                    break;
                case 8:
                    System.out.println("Enter name of song you wish to remove from your playlist");
                    playlist.removeSongFromPlaylist(scanner.nextLine());
                    break;
                case 9:
                    playlist.listAlbums(false);
                    break;
                case 10:
                    playlist.listAlbums(true);
                    break;
                case 11:
                    System.out.println("Type the name of the album you wish to delete");
                    playlist.deleteAlbum(scanner.nextLine());
                    break;
                case 12:
                    quit = true;
                    break;


            }


        }

    }

    public static void printMenu() {
        System.out.println("\nAvailable actions:");
        System.out.println("\n0 - print menu" +
                "\n1 play next song" +
                "\n2 replay current song" +
                "\n3 play previous song" +
                "\n4 - create a new album" +
                "\n5 - add a song to an album" + ///create an album if it doesn't exist
                "\n6 - remove song from an album" +
                "\n7 - add a song to your current playlist" +
                "\n8 - remove a song from your current playlist" +
                "\n9 - get a list of albums" +
                "\n10 - get a list of all your songs" + //bool true
                "\n11 - delete an album" +
                "\n12 quit program"
        );


    }

}
