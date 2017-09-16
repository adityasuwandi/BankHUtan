package com.example.adityasuwandi.bankhutan;

/**
 * Created by AdityaLaksana on 9/16/2017.
 */

public class katalog {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public katalog() {
    }

    public katalog(String nama, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
