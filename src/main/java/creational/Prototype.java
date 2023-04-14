package creational;


class ClonableObject implements Cloneable{
    public String name;
    public Integer roleNo;

    ClonableObject(String name, Integer roleNo){
        this.name = name;
        this.roleNo = roleNo;
    }

    public String getInfo(){
        return "Student Name " + this.name + " with role " + this.roleNo;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Prototype{

    public static void main(String[] args) {
        // Actual Object
        ClonableObject clone1 = new ClonableObject("tahan", 3);

        try {
            // Cloned Object
            ClonableObject clone2 = (ClonableObject) clone1.clone();
            System.out.println(clone2.getInfo());

            System.out.println("---");

            // Cloneable works as a deep copy
            clone1.name = "Ibrahim";
            System.out.println(clone1.getInfo());
            System.out.println(clone2.getInfo());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }



    }
}


