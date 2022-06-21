package lesson5.hard;

//Продвинутый уровень
//Задача №1
// Сделать задачу №1 из базовой.
// 1. Создать класс CarFactory, у которого есть два статических методы: создать жигули, создать toyota.
// 2. Создать 20 тойот, 20 жигулей с помощью CarFactory, положить их в один массив.
// 3. Пройтись по массиву, проверить к какому классу принадлежит машина, привести тип к классу машины
// и вызвать характерные для нее методы.

//Задача №2
// 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
// 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
// 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt() )
// 4. Записать в файл "report.txt" все данные из отчетов.
// 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, то же самое с расходами
// Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)

import lesson5.easy.Car;
import lesson5.easy.Lada;
import lesson5.easy.Toyota;
import java.io.IOException;

import static lesson5.hard.CarFactory.*;

public class Hard {
    public static void main(String[] args) throws IOException {

        //Задача №1

        Car[] carsArray = new Car[40];

        for (int i = 0; i < 20; i++) {
            for (int j = 20; j < 40; j++) {
                carsArray[j] = newToyota();
            }
            carsArray[i] = newLada();
        }

        for (Car car : carsArray) {
            if (car instanceof Lada) {
                ((Lada) car).breakingDown();
            } else if (car instanceof Toyota) {
                ((Toyota) car).playMusic();
            }
        }
        System.out.println();

        //Задача №2

        String report = DataGenerator.createReport();
        System.out.println(report);
        DataGenerator.writeReport(report);

    }
}
