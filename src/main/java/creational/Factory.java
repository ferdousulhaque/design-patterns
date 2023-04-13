package creational;

interface Transport{
    public String run();
}

class Truck implements Transport{
    @Override
    public String run() {
        return "Truck running...";
    }
}

class Ship implements Transport{
    @Override
    public String run() {
        return "Ship running...";
    }
}

public class Factory {
    public static void main(String[] args) throws Exception {
        String type = "ship";
        Transport ride = select(type);
        System.out.println(ride.run());
    }

    public static Transport select(String type) throws Exception{
        if(type.equals("truck")){
            return new Truck();
        } else if (type.equals("ship")) {
            return new Ship();
        }else{
            throw new Exception("Mode not found");
        }
    }
}
