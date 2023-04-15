package structural;

interface Common {
    public double amount();
}

class Product implements Common {
    private final double price = 30;

    @Override
    public double amount() {
        return price;
    }
}

class Box implements Common {
    private final double product_price = 30;
    private final double box_price;

    private Integer products = 0;
    private Integer boxes = 0;

    Box(){
        box_price = 3 * product_price;
    }

    public void add(String type, Integer noOf){
        switch (type){
            case "box" -> boxes += noOf;
            case "product" -> products += noOf;
        }
    }

    public void remove(String type, Integer noOf){
        switch (type){
            case "box" -> boxes -= noOf;
            case "product" -> products -= noOf;
        }
    }

    @Override
    public double amount() {
        return (boxes * box_price) + (products * product_price);
    }
}

public class Composite {
    public static void main(String[] args) {
        Product product = new Product();
        Box box = new Box();
        box.add("box", 10);
        box.add("product", 10);
        box.remove("box", 2);

        double total_price = product.amount() + box.amount();
        System.out.println("Total Price: USD " + total_price);
    }
}
