package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        CoffeeShop shop = new CoffeeShop();


        shop.addMenuItem(new Coffee("Эспрессо", 50, 10, Size.SMALL));
        shop.addMenuItem(new Coffee("Латте", 80, 6, Size.MEDIUM));
        shop.addMenuItem(new Coffee("Американо", 60, 7, Size.LARGE));

        shop.addMenuItem(new Tea("Зеленый чай", 30, "зеленый", Size.MEDIUM));
        shop.addMenuItem(new Tea("Черный чай", 40, "черный", Size.LARGE));
        shop.addMenuItem(new Tea("Каркаде", 60, "красный", Size.SMALL));

        shop.addMenuItem(new Pastry("Круассан", 99.99, "слоеный"));
        shop.addMenuItem(new Pastry("Шоколадный маффин", 125.9, "маффин"));
        shop.addMenuItem(new Pastry("Овсяное печенье", 69.99, "печенье"));

        shop.displayMenu();

        System.out.println("\n=== Оформляем заказы ===");
           //Первый заказ
        List<MenuItem> order1Items = new ArrayList<>();
        order1Items.add(new Coffee("Латте", 80, 6, Size.MEDIUM));
        order1Items.add(new Pastry("Круассан", 99.99, "слоеный"));
        CoffeeShop.Order order1 = shop.placeOrder(order1Items);
        order1.printReceipt();
           //Второй заказ
        List<MenuItem> order2Items = new ArrayList<>();
        order2Items.add(new Tea("Зеленый чай", 30, "зеленый", Size.MEDIUM));
        order2Items.add(new Pastry("Овсяное печенье", 69.99, "печенье"));
        order2Items.add(new Pastry("Овсяное печенье", 69.99, "печенье"));
        CoffeeShop.Order order2 = shop.placeOrder(order2Items);
        order2.printReceipt();


        System.out.println("\n=== Приготовление по заказу ===");
        Coffee coffee = new Coffee("Эспрессо", 50, 10, Size.SMALL);
        Tea tea = new Tea("Зелёный чай", 40, "зеленый", Size.MEDIUM);
        coffee.prepare();
        tea.prepare();

        System.out.println();
        shop.getStats().printStats();

    }
}
