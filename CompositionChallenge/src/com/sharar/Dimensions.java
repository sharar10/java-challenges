package com.sharar;

/**
 * Created by sharararzukrahman on 8/14/16.
 */
public class Dimensions {
    private int width;
    private int height;
    private int depth;

    //we will use this public method to access the private getter
    public Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }
}
