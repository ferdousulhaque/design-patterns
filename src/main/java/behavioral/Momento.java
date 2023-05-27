package behavioral;

import java.util.Stack;

interface MomentInterface {
    void saveState(State state);
    State undo();
}

class Operation implements MomentInterface {
    private Stack<State> states;

    public Operation(){
        this.states = new Stack<>();
    }

    @Override
    public void saveState(State state) {
        this.states.push(state);
    }

    @Override
    public State undo() {
        return this.states.pop();
    }
}

class State {
    int height;
    int width;

    public State(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }
}

public class Momento {
    public static void main(String[] args) {
        Operation operation = new Operation();

        // Add moments
        State state = new State(8, 10);
        operation.saveState(state);
        System.out.println("Area: " + state.getHeight() * state.getWidth());

        state = new State(5, 12);
        operation.saveState(state);
        System.out.println("Area: " + state.getHeight() * state.getWidth());

        // Undo
        State previous = operation.undo();
        System.out.println("Undo Area: " + previous.getHeight() * previous.getWidth());
        previous = operation.undo();
        System.out.println("Undo Area: " + previous.getHeight() * previous.getWidth());
    }
}
