package behavioral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum BabyState {
    PLAYFUL, SLEEPY, POOP
}

interface Observable {
    public void alert(BabyState state);
}

class Dad implements Observable{

    @Override
    public void alert(BabyState state) {
        if(state.equals(BabyState.SLEEPY))
            System.out.println("Dad on the duty. Let's sleep");
    }
}

class Mom implements Observable{

    @Override
    public void alert(BabyState state) {
        if(state.equals(BabyState.PLAYFUL))
            System.out.println("Mom on the duty. Let's play");
    }
}

class Nanny implements Observable{

    @Override
    public void alert(BabyState state) {
        if(state.equals(BabyState.POOP))
            System.out.println("Nanny on the duty. Let's clean");
    }
}

class BabyObserver {
    private List<Observable> observers;
    private BabyState state;

    BabyObserver(){
        observers = new ArrayList<>();
    }

    public void addObservers(Observable observer){
        this.observers.add(observer);
    }

    public void resetObservers(){
        this.observers.clear();
    }

    public void setState(BabyState state){
        this.state = state;
    }

    public void alert(){
        for(Observable observer: observers){
            observer.alert(this.state);
        }
    }

}

public class Observer {
    public static void main(String[] args) {
        BabyObserver babyObserver = new BabyObserver();
        babyObserver.addObservers(new Dad());
        babyObserver.addObservers(new Mom());
        babyObserver.addObservers(new Nanny());
        babyObserver.setState(BabyState.POOP);
        babyObserver.alert();
        babyObserver.resetObservers();


        babyObserver.addObservers(new Dad());
        babyObserver.addObservers(new Mom());
        babyObserver.setState(BabyState.PLAYFUL);
        babyObserver.alert();
        babyObserver.resetObservers();


    }
}
