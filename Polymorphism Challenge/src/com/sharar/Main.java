package com.sharar;

class Car {
    private String carName;
    private boolean engine;
    private int cylinders;
    private int doors;
    private int wheels;
    private String size;

    public Car(String carName, int cylinders, int doors, String size) {
        this.carName = carName;
        this.engine = true;
        this.cylinders = cylinders;
        this.doors = doors;
        this.wheels = 4;
        this.size = size;
    }

    public void startEngine() {
        System.out.println("Starting engine");
    }

    public void stopEngine() {
        System.out.println("Stopping engine");
    }

    public String getCarName() {
        return carName;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getDoors() {
        return doors;
    }

    public String getSize() {
        return size;
    }

}

class Ferrari458 extends Car {
    public Ferrari458() {
        super("Ferrari 458", 8, 2, "Coupe");
    }

    @Override
    public void startEngine() {
        System.out.println("Ferrari engine starting");
    }

    //how to return a class name. this is something that's built in to java. no need to hardcode it
    public String returnClassName() {
        return getClass().getSimpleName();
    }

}

class ToyotaCamry extends Car {
    public ToyotaCamry() {
        super("Toyota Camry", 4, 4, "sedan");
    }

    @Override
    public int getCylinders() {
        System.out.println("This particular one has 4 cylinders");
        return super.getCylinders();
    }


}
class Test extends Car {
    public Test() {
        super("Toyota Camry", 4, 4, "sedan");
    }

    @Override
    public int getCylinders() {
        System.out.println("This particular one has 4 cylinders");
        return super.getCylinders();
    }


}



public class Main {

    public static void main(String[] args) {
        ToyotaCamry camry = new ToyotaCamry();
        Ferrari458 ferrari = new Ferrari458();
        ferrari.startEngine();
        camry.getCylinders();
        camry.startEngine();

        System.out.println(ferrari.returnClassName());

        //we've added an inline class here, notice semicolon right at the end. we can override methods here directly
        //useful for android dev, for example making click listeners, just like JS
        Car ford = new Car("Ford Mustang", 8, 2, "coupe") {
            @Override
            public int getCylinders() {
                System.out.println("This particular one has 8 kacha cylinders");
                return super.getCylinders();
            }
        };
        ford.getCylinders();


    }

    //we refactor -> copied a class over, and then we refactor -> moved it back to our main.java file
    //this is a class inside the main class. we can paste it back above outside the main class
    //static is required since it's in the main class.
    static class Holden extends Car {
        public Holden() {
            super("Toyota Camry", 4, 4, "sedan");
        }

        @Override
        public int getCylinders() {
            System.out.println("This particular one has 4 cylinders");
            return super.getCylinders();
        }



    }


}
