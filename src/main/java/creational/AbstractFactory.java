package creational;

interface Chair{
    public int hasLegs();
    public boolean sitOn();
}

class ArmChair implements Chair{

    @Override
    public int hasLegs() {
        return 4;
    }

    @Override
    public boolean sitOn() {
        return true;
    }
}

class RockingChair implements Chair{

    @Override
    public int hasLegs() {
        return 0;
    }

    @Override
    public boolean sitOn() {
        return true;
    }
}

interface FurnitureCategory{
    public Chair getChair();
}

class ArmCategory implements FurnitureCategory{
    @Override
    public Chair getChair() {
        return new ArmChair();
    }
}

class RockingCategory implements FurnitureCategory{
    @Override
    public Chair getChair() {
        return new RockingChair();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        FurnitureCategory armChair = new ArmCategory();
        Chair chair = armChair.getChair();
        System.out.println("No of legs: " + chair.hasLegs());
    }
}
