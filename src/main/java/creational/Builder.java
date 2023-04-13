package creational;

import java.util.ArrayList;
import java.util.List;

class WoodBuilder {
    Integer garage = 0;
    Integer tree = 0;

    public WoodBuilder WoodBuilder(){
        return this;
    }

    public WoodBuilder withGarage(Integer number){
        garage = number;
        return this;
    }

    public WoodBuilder withTrees(Integer number){
        tree = number;
        return this;
    }

    public WoodBuilder build(){
        return this;
    }

    public List<String> buildSpec(){
        List<String> buildSpec = new ArrayList<>();
        buildSpec.add("No of Garage:"+garage);
        buildSpec.add("No of Trees:"+tree);
        return buildSpec;
    }
}

public class Builder {
    public static void main(String[] args) {
        WoodBuilder builder = new WoodBuilder()
                .withGarage(4)
                .withTrees(10)
                .build();
        System.out.println(builder.buildSpec());
    }
}
