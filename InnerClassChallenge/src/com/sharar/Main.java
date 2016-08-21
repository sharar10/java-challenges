package com.sharar;

import java.util.*;

public class Main {

    //goal was to implement innerclasses in album class without changing song.java or main.java
    //base code was provided by instructor

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep purple");
        album.addSong("Shakalo", 3.4);
        album.addSong("Grand", 3.4);
        album.addSong("Vaga", 3.34);
        album.addSong("Dika", 2.4);
        album.addSong("Shaka", 1.4);
        album.addSong("Maka", 5.4);
        album.addSong("Puka", 4.4);
        albums.add(album);

        album = new Album("Chatper 4", "Slipknot");
        album.addSong("Custer", 2.5);
        album.addSong("Duality", 3.1);
        album.addSong("Before I Forget", 1.5);
        album.addSong("Psychosocial", 4.1);
        album.addSong("Blister Exists", 3.2);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("Shakalo", playList);
        albums.get(0).addToPlaylist("Grand", playList);
        albums.get(0).addToPlaylist("Dika", playList);
        albums.get(0).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist(2, playList);
        albums.get(1).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist(4, playList);
        albums.get(1).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist(6, playList); //this should fail.

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    //how to remove from linklist using listiterator, but you can get exceptions so we need to fix it
                    if (playList.size() > 0) {
                        listIterator.remove();
                        //after removing we're going to avoid any potential errors by playing the next song or previous song, whatever is available
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing" + listIterator.previous());
                        } else System.out.println();
                    }
                    break;
            }
        }
    }


    private static void printMenu() {
        System.out.println("Available actions: \npress");
        System.out.println("0 - quit\n" +
                "1 - play next song\n" +
                "2 - to play previous song\n" +
                "3 - replay current song\n" +
                "4 - list songs in playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("============================");
    }


}
