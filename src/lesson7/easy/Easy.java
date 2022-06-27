package lesson7.easy;

//Базовый уровень
//Задача №1
//1. Создать два класса, которые умеют летать: самолет и утка. Атрибут утки: isInjured (ранен),
// атрибут самолета: countPassengers.
//2. Создать интерфейс, который объединяет эти два класса.
//3. Имплементировать его в двух классах
//4. Реализовать метод летать:
// Для утки:
// Метод летать будет выкидывать ошибку FlyException (создать такой класс), если утка подстрелена,
// иначе печатать на экран "утка летит"
// Для самолета:
// Метод летать будет выкидывать ошибку FlyException, если количество пассажиров меньше нуля.
// Иначе печать "самолет летит"
//5. Создать 1 утку не раненую, 1 утку раненую, 1 самолет с 10 пассажирами, 1 самолет с -1 пассажиром.
//6. Вызвать у них метод летать
// Перехватить исключения: вывести на экран message ошибки
// Ожидание:
// утка летит
// Ошибка: утка ранена
// самолет летит
// Ошибка: пассажиров в самолете меньше 0


public class Easy {

    //Задача №1

    public static void main(String[] args) {

        Duck duckHealthy = new Duck(false);
        Duck duckDead = new Duck(true);
        Plane plane = new Plane(10);
        Plane planeFromMatrix = new Plane(-1);

        Flyable[] flyables = {duckHealthy, duckDead, plane, planeFromMatrix};

        for (Flyable flyable : flyables)
            try {
                flyable.fly();
            } catch (FlyException | DuckException flyException) {
                System.out.println(flyException.getMessage());
            }
    }
}
