package lesson7.hard.task2;

import java.util.ArrayList;

public class Hard2 {
    public static void main(String[] args) {
        Watch goodWatch = new Watch(false);
        Watch brokenWatch = new Watch(true);
        Employee employee1 = new Employee(goodWatch);
        Employee employee2 = new Employee(brokenWatch);
        Shop shop1 = new Shop(employee1);
        Shop shop2 = new Shop(employee2);
        BrandChanel brandChanel = new BrandChanel(shop1, shop2);

        for (Shop shop : brandChanel.getShops()) {
            for (Employee employee : shop.getEmployees()) {
                Watch watch = employee.getWatch();
                try {
                    watch.tikTak();

                } catch (WatchBrokenError e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
