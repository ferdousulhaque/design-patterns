package creational;

final class ExampleSingeton {
    public Integer value;

    private static ExampleSingeton instance;

    private ExampleSingeton(Integer value){
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static ExampleSingeton getInstance(Integer value){
        if(ExampleSingeton.instance == null){
            ExampleSingeton.instance = new ExampleSingeton(value);
        }
        return ExampleSingeton.instance;
    }
}

public class Singleton {
    public static void main(String[] args) {
        ExampleSingeton singleton = ExampleSingeton.getInstance(100);
        System.out.println(singleton.value);
    }

}
