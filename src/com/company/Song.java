package com.company;

public class Song {
    private String name;
    private double songTime;

    public Song(String name, double songTime) {
        this.name = name;
        this.songTime = songTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.songTime;
    }
}
