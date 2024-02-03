class Bicycle {
    private int gear;
    private int speed;

    // Constructor
    Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    // Method to increase speed
    void speedUp(int increment) {
        speed += increment;
    }

    // Method to print info
    void printInfo() {
        System.out.println("Gear: " + gear + "\nSpeed: " + speed);
    }
}

public class Main {
    public static void main(String args[]) {
        Bicycle bike = new Bicycle(3, 100);
        bike.speedUp(20);
        bike.printInfo();
    }
}