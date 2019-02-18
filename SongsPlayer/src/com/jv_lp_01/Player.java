package com.jv_lp_01;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Player {

    private PlayList playlist = new PlayList();
    private ArrayList<Album> albums = new ArrayList<Album>();
    private Scanner scanner = new Scanner(System.in);
    private boolean forwardDirection = true;
    private ListIterator<Song> songIt = playlist.getSongs().listIterator();


    public void initAlbums() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            albums.add(new Album("Album-" + i));
            for (int j = 1; j <= 20; j++) {
                albums.get(i - 1).getSongs().add(new Song("Album-" + i + "-Song-" + j, 2));
            }
        });
    }

    public void initPlayList() {
        playlist.getSongs().add(albums.get(1).getSongs().get(2));
        playlist.getSongs().add(albums.get(2).getSongs().get(4));
        playlist.getSongs().add(albums.get(3).getSongs().get(6));
        playlist.getSongs().add(albums.get(4).getSongs().get(8));
        playlist.getSongs().add(albums.get(5).getSongs().get(10));
        playlist.getSongs().add(albums.get(6).getSongs().get(12));
        playlist.getSongs().add(albums.get(7).getSongs().get(14));
        playlist.getSongs().add(albums.get(8).getSongs().get(16));
        playlist.getSongs().add(albums.get(9).getSongs().get(18));
    }

    public int pickAlbum() {
        listAlbums();
        return scanner.nextInt();
    }

    public void pickSong() {
        Song s = albums.get(pickAlbum()).pickSong();
        playlist.getSongs().add(s);
        System.out.println("Added to playlist: " + s.getName());

    }

    public void listAlbums() {
        IntStream.rangeClosed(1, albums.size()).forEach(i -> {
            System.out.println((i + 1) + " - " + albums.get(i).getName());
        });
    }

    public void listSongs() {
        IntStream.rangeClosed(0, playlist.getSongs().size()-1).forEach(i -> {
            System.out.println((i + 1) + " - " + playlist.getSongs().get(i).getName() + " / " + playlist.getSongs().get(i).getDuration());
        });

    }

    public void skipForward() {
        if (!forwardDirection) {
            if (this.songIt.hasNext()) this.songIt.next();
            forwardDirection = true;
        }
        if (this.songIt.hasNext()) {
            Song s = this.songIt.next();
            System.out.println("Playing : " + s.getName() + " / " + s.getDuration() + " s. ");
        } else {
            System.out.println("End of play list");
            forwardDirection = false;
        }
    }

    public void skipBackwards() {
        if (forwardDirection) {
            if (songIt.hasPrevious()) songIt.previous();
            forwardDirection = false;
        }
        if (songIt.hasPrevious()) {
            Song s = songIt.previous();
            System.out.println("Playing : " + s.getName() + " / " + s.getDuration() + " s. ");
        } else {
            System.out.println("Start of play list");
            forwardDirection = true;
        }
    }

    public void removeSong() {
        listSongs();
        int idToRemove = scanner.nextInt();
        Song s= playlist.getSongs().get(idToRemove -1);
        System.out.println("Removing " + s.getName() );
        playlist.getSongs().remove(idToRemove - 1);
    }

    public void mainMenu() {
        String menu = "0 - Quit\n";
        menu += "1 - Add songs\n";
        menu += "2 - List playlist\n";
        menu += "3 - Remove song\n";
        menu += "4 - Activate Player \n";
        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();

        switch (opt) {
            case 0:
                return;
            case 1:
                break;
            case 2:
                playlist.listSongs();
                break;
            case 3:
               removeSong();
                break;
            case 4:
                player();
                break;
            default:

                mainMenu();
                break;
        }
        mainMenu();

    }

    public void player(){
        boolean quit = false;
        ListIterator<Song> songIt = playlist.getSongs().listIterator();
        printPlayerMenu();
        Song s = null;
        while(!quit) {
            int opt = scanner.nextInt();
            switch (opt) {
                case 0:
                    quit = true;
                case 1:
                    if (!forwardDirection) {
                        if (songIt.hasNext()) songIt.next();
                        forwardDirection = true;
                    }
                    if (songIt.hasNext()) {
                        s = songIt.next();
                        System.out.println("Forward, playing " + s.getName() + " / " + s.getDuration() + " s. ");
                    } else {
                        System.out.println("Reached end of list");
                        forwardDirection = false;
                    }
                    break;
                case 2:

                    if (forwardDirection) {
                        if (songIt.hasPrevious()) songIt.previous();
                        forwardDirection = false;
                    }
                    if (songIt.hasPrevious()) {
                        s = songIt.previous();
                        System.out.println("Backward, playing " + s.getName() + " / " + s.getDuration() + " s. ");
                    } else {
                        System.out.println("Reached end of list");
                        forwardDirection = true;
                    }
                    break;
                case 3:
                    if(s != null){
                        System.out.println("Replaying, playing " + s.getName() + " / " + s.getDuration() + " s. ");
                    }
                    break;
                default:
                    break;
            }
            printPlayerMenu();
        }

    }

    public void printPlayerMenu(){
        String menu = "0 - exit\n";
        menu += "1 - Forward\n";
        menu += "2 - Backward\n";
        menu += "3 - Replay\n";
        System.out.println(menu);
    };
}
