package org.example;

public class Pastry extends MenuItem{
    private String pastryType;

    public Pastry(String name, double price, String infoPastryType) {
        super(name, price);
        this.pastryType = infoPastryType;
    }

    public String getPastryType() {
        return pastryType;
    }
}
