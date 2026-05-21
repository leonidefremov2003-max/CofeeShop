package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    private List<MenuItem> menu;
    private List<Order> orders;
    private CoffeeShopStats stats;


    public CoffeeShop() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
        stats = new CoffeeShopStats();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
        System.out.println("Товар \"" + item.getName() + "\" добавлен в меню.");
    }

    public void displayMenu() {
        System.out.println("=== Меню кофейни ===");
        for(MenuItem item : menu) {
            System.out.print("- " + item.getName() + " (" + item.getPrice() + " руб.)");
            if(item instanceof Coffee) {
                Coffee c = (Coffee) item;
                System.out.print(" [Кофе, крепость: " + c.getStrength() + ", размер: " + c.getSize() + "]");
            } else if (item instanceof Tea) {
                Tea t = (Tea) item;
                System.out.println(" [Чай, тип: " + t.getTeaType() + ", размер: " + t.getSize() + "]");
            } else if (item instanceof  Pastry) {
                Pastry p = (Pastry) item;
                System.out.println(" [Выпечка, вид: " + p.getPastryType() + "]");
            }
            System.out.println();
        }
    }

    public Order placeOrder(List<MenuItem> items) {
        Order order = new Order(items);
        orders.add(order);
        stats.recordOrder(order);
        return order;
    }

    public CoffeeShopStats getStats() {
        return stats;
    }


     class Order {
        private List<MenuItem> items;
        private double total;

        public Order(List<MenuItem> items) {
            this.items = items;
            this.total = 0;
            for (MenuItem item : items) {
                total += item.getPrice();   // суммируем цены
            }
        }

        public void printReceipt() {
            System.out.println("=== Чек ===");
            for (MenuItem item : items) {
                System.out.printf("%-20s %6.2f руб.\n", item.getName(), item.getPrice());
            }
            System.out.println("----------------------");
            System.out.printf("Итого: %15.2f руб.\n", total);
        }

        public double getTotal() {
            return total;
        }

        public int getItemCount() {
            return items.size();
        }
    }


     static class CoffeeShopStats {

        private int totalOrders;
        private double totalRevenue;
        private int totalItemsSold;


        public CoffeeShopStats() {
            totalOrders = 0;
            totalRevenue = 0;
            totalItemsSold = 0;
        }

        public void recordOrder(Order order) {
            totalOrders++;
            totalRevenue += order.getTotal();
            totalItemsSold += order.getItemCount();
        }

        public void printStats() {
            System.out.println("=== Статистика кофейни ===");
            System.out.println("Всего заказов: " + totalOrders);
            System.out.println("Общая выручка: " + totalRevenue + " руб.");
            System.out.println("Продано товаров: " + totalItemsSold);
        }

        public int getTotalOrders() {
            return totalOrders;
        }

        public double getTotalRevenue() {
            return totalRevenue;
        }

        public int getTotalItemsSold() {
            return totalItemsSold;
        }
    }
}
