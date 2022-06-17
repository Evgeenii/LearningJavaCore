package lesson3.hard;

import java.util.Arrays;

public class Hard {
    public static void main(String[] args) {

        // Продвинутый уровень

        // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
        // пока не получится больше 1_000_000.
        // Вывести на экран, количество итераций, которое потребовалось, чтобы дойти до миллиона.
        // Если число отрицательное, то сразу заканчиваем цикл, ничего не выводя.
        // Внимание: число может измениться, и не должно приводить к изменению вашего кода.

        double increment = 0.01123;
        double result = 0;
        int i = 0;
        while (result < 1_000_000) {
            result += increment;
            i++;
        }
        System.out.println("Для получения числа " + Math.round(result) + " потребовалось " + i + " итераций" + "\n");

        // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый четный элемент на 0;
        // Например, дано: [1,1,1,1,1]
        // Ожидаемый результат: [0,1,0,1,0]
        // Подсказка: прочитай про операнд "%".

        int[] array = {1, 1, 1, 1, 1};

        for (int j = 0; j < array.length; j++) {
            if (j % 2 == 0) {
                array[j] = 0;
            }
        }
        System.out.println(Arrays.toString(array) + "\n");

        // Задание №3:
        // Дано:
        // В автосервис приехала сломанная машина. Механики находят неисправность следующим способом:
        // Если у машины нет бензина и ничего не сломано, то отдают машину владельцу и берут 1000 рублей за консультацию.
        // Если у машины проблема с двигателем, то чинят и берут 10 000.
        // Если у машины проблема с электрикой, то чинят и берут 5000.
        // Если у машины проблема с коробкой передач, то чинят и берут 4000.
        // Если у машины проблема с колесами, то чинят и берут 2000.
        // Если две детали сломаны, то на общий счет идет скидка 10%.
        // Если сломана коробка передач, и электрика или двигатель, то на общий счет скидка 20%.
        // Если нет бензина и что-то сломано, то за консультацию денег не берут.
        // Ситуации, что бензин есть и ничего не сломано - быть не может.
        // Ожидаемый результат: выведен на экран счет клиенту.

        boolean hasFuel = false;
        boolean hasElectricsProblem = true;
        boolean hasMotorProblem = true;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = true;

        int price = 0;
        int resultPrice = 0;
        double discount = 0;
        int failureCount = 0;

        if (!hasFuel || (hasMotorProblem || hasElectricsProblem || hasTransmissionProblem || hasWheelsProblem)) {
            if (!hasFuel && (hasMotorProblem || hasElectricsProblem || hasTransmissionProblem || hasWheelsProblem)) {
                System.out.println("У вас нет бензина. И мы обнаружили неисправность. Консультация бесплатно.");
            } else if (!hasFuel && !(hasMotorProblem && hasElectricsProblem && hasTransmissionProblem && hasWheelsProblem)) {
                price = 1000;
                resultPrice = resultPrice + price;
                System.out.println("У вас кончился бензин. С вас " + price + " рублей.");
            }

            if (hasMotorProblem) {
                failureCount++;
                price = 10000;
                resultPrice = resultPrice + price;
                System.out.println("За проблему с двигателем с вас " + price + " рублей.");
            }
            if (hasElectricsProblem) {
                failureCount++;
                price = 5000;
                resultPrice = resultPrice + price;
                System.out.println("За проблему с электрикой с вас " + price + " рублей.");
            }
            if (hasTransmissionProblem) {
                failureCount++;
                price = 4000;
                resultPrice = resultPrice + price;
                System.out.println("За проблему с трансмиссией с вас " + price + " рублей.");
            }
            if (hasWheelsProblem) {
                failureCount++;
                price = 2000;
                resultPrice = resultPrice + price;
                System.out.println("За проблему с колесами с вас " + price + " рублей.");
            }

            if (hasTransmissionProblem & (hasElectricsProblem || hasMotorProblem)) {
                discount = 0.2;
                System.out.println("Ваша скидка " + (int) (discount * 100) + "%.");
            } else if (failureCount > 1) {
                discount = 0.1;
                System.out.println("Ваша скидка " + (int) (discount * 100) + "%.");
            }
            resultPrice = (int) (resultPrice - (resultPrice * discount));
            System.out.println("Итого: " + resultPrice + " рублей.");

        } else System.out.println("Кажется, с машиной все в порядке.");

        System.out.println("\n");

        // Задание №4:
        // Написать систему управления складскими запасами. Создать класс склад, создать класс работники
        // (написать геттеры на все аттрибуты).
        // Количество работников минимум 3.
        // Работники берут из склада товар, и портят его. Нужно написать взаимодействие через методы работников и склад:
        // Работник берет из склада товар, на складе товар уменьшается. Работник когда взял товар, выводит на экран
        // "Ура я испортил водку!" и добавляет к себе в журнал количество испорченного товара.
        // У склада есть только одна позиция - Водка.

        Storage storage = new Storage("Russian Vodka", 3);
        Employee vladimir = new Employee("Vladimir", 0);
        Employee dimitri = new Employee("Dimitri", 0);
        Employee rafik = new Employee("Rafik", 0);

        System.out.println("Количество водки на складе: " + storage.getCountBottle() + "\n");

        destroyVodka(storage, vladimir);
        destroyVodka(storage, dimitri);
        destroyVodka(storage, rafik);

        System.out.println("\n");
        System.out.println("Количество водки на складе после работы: " + storage.getCountBottle());


    }

    private static void destroyVodka(Storage storage, Employee employee) {
        employee.setDestroyedBottles();
        storage.setCountBottle();

        System.out.println("\"Ура, я испортил водку!\", "
                + "сотрудник: "
                + employee.getEmployeeName()
                + ". Испорчено водки сегодня: " + employee.getDestroyedBottles());

    }
}
