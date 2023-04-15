package structural;

interface Clothing {
    public void putOn();
}

class getReadyWrapper implements Clothing{
    public void putOn(){
    }
}

class tShirt extends getReadyWrapper{
    @Override
    public void putOn() {
        super.putOn();
    }
}

class jacket extends getReadyWrapper{
    private final Clothing wrapee;

    jacket(Clothing wrapee){
        this.wrapee = wrapee;
    }

    @Override
    public void putOn() {
        this.wrapee.putOn();
        System.out.println("RainCoat");
    }
}

class rainCoat extends getReadyWrapper{
    private final Clothing wrapee;

    rainCoat(Clothing wrapee){
        this.wrapee = wrapee;
    }

    @Override
    public void putOn() {
        this.wrapee.putOn();
        System.out.println("RainCoat");
    }
}



public class Decorator {
    public static void main(String[] args) {
        Clothing tShirt = new tShirt();
        Clothing jacket = new jacket(tShirt);
        Clothing rainCoat = new rainCoat(jacket);
        rainCoat.putOn();
    }
}
