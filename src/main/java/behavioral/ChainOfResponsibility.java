package behavioral;

interface Handlers {
    void nextHandler(Handlers handlers);
    void handle(Types type);
}

enum Types {
    WORK1, WORK2, WORK3
}

class Chain1 implements Handlers{
    private Handlers handler;

    @Override
    public void nextHandler(Handlers handlers) {
        this.handler = handlers;
    }

    @Override
    public void handle(Types type) {
        // Check if it's work
        if(type.equals(Types.WORK1)){
            System.out.println("Chain 1 Job Starting...");
        }else{
            // Pass it to next
            if(handler != null){
                handler.handle(type);
            }
        }
    }
}

class Chain2 implements Handlers{
    private Handlers handler;

    @Override
    public void nextHandler(Handlers handlers) {
        this.handler = handlers;
    }

    @Override
    public void handle(Types type) {
        // Check if it's work
        if(type.equals(Types.WORK2)){
            System.out.println("Chain 2 Job Starting...");
        }else{
            // Pass it to next
            if(handler != null){
                handler.handle(type);
            }
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Prepare the Chain of Command
        Chain1 chain1 = new Chain1();
        Chain2 chain2 = new Chain2();
        chain1.nextHandler(chain2);

        Types job = Types.WORK2;
        System.out.println("Job for "+job.name());
        chain1.handle(job);
    }
}
