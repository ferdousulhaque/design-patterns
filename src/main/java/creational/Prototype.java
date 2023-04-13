package creational;


class ClonableObject implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Prototype{

    public static void main(String[] args) {
        Cloneable clone1 = new ClonableObject();
        Cloneable clone2 = (ClonableObject) clone1.clone();
    }
}


