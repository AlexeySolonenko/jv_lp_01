package com.jv_lp_01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Album {

    private ArrayList<Song> songs = new ArrayList<Song>();
    private String name;

    public Album(){

    }

    public Album(String name) {
        this.name = name;
    }

    public Song pickSong(){
        listSongs();
        Scanner scanner = new Scanner(System.in);
        return songs.get(scanner.nextInt());

    }

    public void listSongs(){
        IntStream.rangeClosed(1,songs.size()).forEach(i -> {
            System.out.println((i+1) + " - " + songs.get(i).getName() + " / " + songs.get(i).getDuration() + "s");
        });
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
