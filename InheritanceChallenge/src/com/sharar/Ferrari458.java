package com.sharar;

/**
 * Created by sharararzukrahman on 8/14/16.
 */
public class Ferrari458 extends Car {
    private int roadServiceMonths;

    public Ferrari458(int roadServiceMonths) {
        super("Ferrari 458", "Coupe", 2, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate (int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity ==0) {
            stop();
            changeGear(1);
        } else if (newVelocity >0 && newVelocity <=10) {
            changeGear(1);
        } else if (newVelocity > 10 ) {
            changeGear(2);
        } else if (newVelocity >20) {
            changeGear(3);
        } else {
            changeGear(4);
        }

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }

}
