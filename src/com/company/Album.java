package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String songName, double songTime){
        if(findSong(songName) == null) {
            this.songs.add(new Song(songName, songTime));
            return true;
        }
        return false;
    }

    private Song findSong(String songName){
        for(Song checkSong: this.songs){
            if(checkSong.getName().equals(songName)) {
                return checkSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if((index >= 0) && (index <= playlist.size())){
           playlist.add(this.songs.get(index));
        }else {
            System.out.println("This album does not have a track " + trackNumber);
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);

        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public void printAlbum(){
        for(int i = 0; i < songs.size(); i++){
            System.out.println((i+1) + ". " + songs.get(i).getName() + " - " + songs.get(i).toString() + "min");
        }
    }


}
