package com.jv_lp_01;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {

    LinkedList<Song> songs = new LinkedList<Song>();

    public PlayList() {

    }

    public void listSongs(){
        ListIterator<Song> s = songs.listIterator();
        while(s.hasNext()){
            Song song = s.next();
            System.out.println("Song name: " + song.getName() + ". Duration: " + song.getDuration());
        }
    }


    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void setSongs(LinkedList<Song> songs) {
        this.songs = songs;
    }
}
