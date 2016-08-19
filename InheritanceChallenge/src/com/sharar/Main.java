package com.sharar;

public class Main {

    //remember that there are a few methods that are inherited by every class. you can override those if you want to
    //every class has object as a SuperClass
    public static void main(String[] args) {
        Ferrari458 myFerrari458 = new Ferrari458(36);
        myFerrari458.accelerate(40);
        myFerrari458.steer(45);
        myFerrari458.steer(-30);

    }

}
