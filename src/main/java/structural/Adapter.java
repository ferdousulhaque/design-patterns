package structural;

import java.text.DecimalFormat;

interface Metrics {
    public double getDistance();
    public double getWeight();
}

class UKMetrics implements Metrics{
    // In Kilometers
    public double distance;

    // In Kilograms
    public double weight;

    UKMetrics(double distance,double weight){
        this.distance = distance;
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public double getWeight() {
        return weight;
    }
}

class UkToUsAdapter implements Metrics{
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public double distance;

    // In Kilograms
    public double weight;

    UkToUsAdapter(Metrics ukType){
        this.distance = Double.parseDouble(df.format(ukType.getDistance() * 0.621371));
        this.weight = Double.parseDouble(df.format(ukType.getWeight() * 2.20462));
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

public class Adapter {

    public static void main(String[] args) {
        Metrics uk = new UKMetrics(50, 80);
        System.out.println("UK Type: Distance " + uk.getDistance() + " KM and weight " + uk.getWeight() + " Kg");

        // Adapter to US type
        Metrics us = new UkToUsAdapter(uk);
        System.out.println("UK Type: Distance " + us.getDistance() + " Miles and weight " + us.getWeight() + " lbs");
    }


}
