package com.sharar;

/**
 * Created by sharararzukrahman on 8/14/16.
 */
public class Car extends Vehicle {

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;
    private int currentGear;

    public Car(String name, String size, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = 4;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear() changed to gear" + this.currentGear);
    }
    public void changeVelocity(int speed, int direction) {
        super.move(speed, direction);
        System.out.println("Car.changeVelocity() : Velocity "+ speed + " direction " + direction);
    }


}
