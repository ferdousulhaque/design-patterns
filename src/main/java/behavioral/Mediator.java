package behavioral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum HandymanTypes {
    ELECTRICIAN, PLUMBER, PAINTER
}

interface Handyman {
    public void job();
}

interface MediatorInterface{
    public void addListener(HandymanTypes type, Handyman handyman);
    public void broadcast();
}

class EletricianA implements Handyman{
    EletricianA(MediatorInterface mediator){
        mediator.addListener(HandymanTypes.ELECTRICIAN, this);
    }

    @Override
    public void job(HandymanTypes type) {

    }
}

class AlertHandyman implements MediatorInterface{
    HashMap<String, List<Handyman>> listeners;
    List<Handyman> listOfHandyman;

    AlertHandyman(){
        this.listeners = new HashMap<>();
        listOfHandyman = new ArrayList<>();
    }

    @Override
    public void addListener(HandymanTypes type, Handyman handyman) {
        listOfHandyman.add(handyman);
        this.listeners.put(type.toString(), listOfHandyman);
    }

    @Override
    public void broadcast(HandymanTypes type) {
        if(type.equals(HandymanTypes.ELECTRICIAN)){
            for(handyman: List<Handyman> handymans){
                handyman.
            }
        }
    }
}

public class Mediator {
    public static void main(String[] args) {
        MediatorInterface mediator = new AlertHandyman();
        Handyman electrician = new EletricianA(mediator);
        mediator.
    }
}
