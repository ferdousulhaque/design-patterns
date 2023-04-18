package behavioral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum HandymanTypes {
    ELECTRICIAN, PLUMBER
}

interface Handyman {
    public void job();
}

interface MediatorInterface{
    public void addListener(HandymanTypes type, Handyman handyman);
    public void broadcast(HandymanTypes type);
}

class Eletrician implements Handyman{
    Eletrician(MediatorInterface mediator){
        mediator.addListener(HandymanTypes.ELECTRICIAN, this);
    }

    @Override
    public void job() {
        System.out.println("Electrician on the way");
    }
}

class Plumber implements Handyman{
    Plumber(MediatorInterface mediator){
        mediator.addListener(HandymanTypes.PLUMBER, this);
    }

    @Override
    public void job() {
        System.out.println("Plumber on the way");
    }
}

class AlertHandyman implements MediatorInterface{
    HashMap<String, List<Handyman>> listeners;
    List<Handyman> listOfHandymanElectrician;
    List<Handyman> listOfHandymanPlumber;

    AlertHandyman(){
        this.listeners = new HashMap<>();
        listOfHandymanElectrician = new ArrayList<>();
        listOfHandymanPlumber = new ArrayList<>();
    }

    @Override
    public void addListener(HandymanTypes type, Handyman handyman) {
        if(type.equals(HandymanTypes.ELECTRICIAN)){
            listOfHandymanElectrician.add(handyman);
            this.listeners.put(type.toString(), listOfHandymanElectrician);
        }else if(type.equals(HandymanTypes.PLUMBER)){
            listOfHandymanPlumber.add(handyman);
            this.listeners.put(type.toString(), listOfHandymanPlumber);
        }
    }

    @Override
    public void broadcast(HandymanTypes type) {
        if(type.equals(HandymanTypes.ELECTRICIAN)){
            System.out.println(this.listeners);
        }else if(type.equals(HandymanTypes.PLUMBER)){
            System.out.println(this.listeners);
        }
    }
}

public class Mediator {
    public static void main(String[] args) {
        MediatorInterface mediator = new AlertHandyman();
        Handyman electrician = new Eletrician(mediator);
        Handyman plumberA = new Plumber(mediator);
        Handyman plumberB = new Plumber(mediator);
        mediator.broadcast(HandymanTypes.ELECTRICIAN);
    }
}
