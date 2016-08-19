package com.sharar;

public class Main {

    public static void main(String[] args) {
        Dimensions bedDimensions = new Dimensions(30,30,30);
        Bed myBed = new Bed("Ikea","Queen",bedDimensions);
        Room bedroom = new Room(myBed, 4);
        bedroom.getTheBed().returnDimensions();

    }
}
