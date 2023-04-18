package behavioral;

import java.util.Scanner;

interface Transport {
    public double cost();
}

class Bicycle implements Transport{

    @Override
    public double cost() {
        return 50;
    }
}

class Truck implements Transport {

    @Override
    public double cost() {
        return 100;
    }
}

class Motorcycle implements Transport {

    @Override
    public double cost() {
        return 150;
    }
}

public class Strategy {
    public static void main(String[] args) throws RuntimeException{
        Scanner input = new Scanner(System.in);
        System.out.print("Mode of Transport (1-Bicycle, 2-Truck, 3-Motorcycle): ");
        int modeValue = input.nextInt();
        Transport transport;

        switch (modeValue){
            case 1 -> transport = new Bicycle();
            case 2 -> transport = new Truck();
            case 3 -> transport = new Motorcycle();
            default -> throw new RuntimeException("Invalid Transport Mode");
        }

        System.out.println("Costing: "+ transport.cost());
    }
}
