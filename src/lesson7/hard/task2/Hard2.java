package lesson7.hard.task2;

//Задача №2
//2. Создать следующую структуру из классов и интерфейсов
// магазин (обладает работниками)
// работник (обладает часами)
// часы (умеют тикать, если сломаны выкидывают ошибку WatchBrokenError)
// Бренд (обладает массивом магазинов)
// Создать бренд, положить в него два магазина, в каждом магазине будет по работнику,
// у каждого работника по часам. У одного работника часы сломаны, у второго нет.
// После создания бренда, вытащить из него все часы и вызвать у всех часов метод тикать,
// обработать ошибку сломанных часов.
// Ожидание вывода на экран:
// Часы тикают
// Ошибка: Часы сломались.

public class Hard2 {
    public static void main(String[] args) {
        Watch goodWatch = new Watch(false);
        Watch brokenWatch = new Watch(true);
        Employee employee1 = new Employee(goodWatch);
        Employee employee2 = new Employee(brokenWatch);
        Shop shop1 = new Shop(employee1);
        Shop shop2 = new Shop(employee2);
        Shop[] shopsArr = new Shop[] {shop1, shop2};
        BrandChanel chanel = new BrandChanel(shopsArr);

        for (Shop shop : chanel.getShopArray()) {
            try {
                shop.getEmployee().getWatch().tikTak();
            } catch (WatchBrokenError e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

