package com.sharar;

/**
 * Created by sharararzukrahman on 8/14/16.
 */
public class Bed {
    private String brand;
    private String size;
    private Dimensions dimensions;

    public Bed(String brand, String size, Dimensions dimensions) {
        this.brand = brand;
        this.size = size;
        this.dimensions = dimensions;
    }
    public void returnDimensions() {
        System.out.println(this.getDimensions().getDepth() + " " + this.getDimensions().getHeight() + " " + this.getDimensions().getWidth());
    }

    private String getBrand() {
        return brand;
    }

    private String getSize() {
        return size;
    }

    private Dimensions getDimensions() {
        return dimensions;
    }
}
