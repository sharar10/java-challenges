package com.sharar;

/**
 * Created by sharararzukrahman on 8/14/16.
 */
public class Room {

    private Bed theBed;
    private int windows;

    public Room(Bed theBed, int windows) {
        this.theBed = theBed;
        this.windows = windows;
    }

    public Bed getTheBed() {
        return theBed;
    }

    public int getWindows() {
        return windows;
    }
}
