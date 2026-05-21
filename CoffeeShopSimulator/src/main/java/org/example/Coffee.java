package org.example;

public class Coffee extends MenuItem implements Preparable{

    private int strength;
    private Size size;

    public Coffee(String name, double price, int strength, Size size) {
        super(name, price);
        this.strength = strength;
        this.size = size;
    }

    public int getStrength() {
        return strength;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public void prepare() {
        System.out.println("Готовим кофе \"" + name + "\":");
        System.out.println("  - Крепость: " + strength + "/10");
        System.out.println("  - Размер: " + size);
        System.out.println("  - Мелим зерна, ждём 5 минут...");
        System.out.println("Кофе \"" + name + "\" готов!");
    }
}
