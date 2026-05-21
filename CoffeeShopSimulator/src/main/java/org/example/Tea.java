package org.example;

public class Tea extends MenuItem implements Preparable{

    private String teaType;
    private Size size;

    public Tea(String name, double price, String teaType, Size size) {
        super(name, price);
        this.teaType = teaType;
        this.size = size;
    }

    public String getTeaType() {
        return teaType;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public void prepare() {
        System.out.println("Готовим чай \"" + name + "\":");
        System.out.println("  - Тип: " + teaType);
        System.out.println("  - Размер: " + size);
        System.out.println("  - Завариваем листья, ждём 3 минуты...");
        System.out.println("Чай \"" + name + "\" готов!");
    }
}
