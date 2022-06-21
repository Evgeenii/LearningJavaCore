package lesson5.easy;

//Базовый уровень


//Дано: у нас есть две модели машин - жигули и toyota. Каждая из этих машин умеет: начинать движение,
//останавливаться, включать фары. У жигули есть особенность: она ломается. У Toyota особенность: включает музыку
//Необходимо:
// 1.Создать абстрактный класс, который будет описывать общие действия этих машин (методы будут не абстрактные)
// 2.Создать два класса, которые будут наследоваться от абстрактного класса, и реализовывать особенности этих машин
// Методы должны просто печатать на экран действия машин (начал движение, включил музыку и тд.)

//Задача №2

//Необходимо:
// 1. Создать папку resource, пометить ее как папку Resources root.
// 2. Создать в ней файл "my_first_file.txt". На первой строке написать: "Моя бабушка", на второй: "читает газету жизнь"
// 3. Прочитать файл, и вывести на экран все слова файла в одну строку
// Ожидаемый результат: "Моя бабушка читает газету жизнь"

//Задача №3

//Необходимо:
// 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
// 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
// 3. Создать объект этого класса прямо здесь (class Homework3, метод main), с доходами 500, расходами 300
// 4. Записать в файл "report.txt" данные из объекта класса.
// Ожидаемый результат: в файле report.txt - одна строка: доходы = 500, расходы 300


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Easy {

    public static void main(String[] args) throws IOException {

        //Задача №1

        Lada lada = new Lada();
        Toyota toyota = new Toyota();

        toyota.start();
        lada.lightsOn();
        lada.breakingDown();
        toyota.playMusic();
        System.out.println();

        //Задача №2

        Path path = Path.of("resource/my_first_file.txt");
        String list = Files.readString(path);
        StringBuilder stringBuilder = new StringBuilder(list);
        int newLineIndex = stringBuilder.indexOf("\n");
        int endIndex = list.length();
        String firstString = list.substring(0, newLineIndex);
        String secondString = list.substring(newLineIndex + 1, endIndex);
        System.out.print(firstString + " " + secondString);
        System.out.println();

        //Задача №3

        FinancialRecord record1 = new FinancialRecord(500, 300);
        FileWriter fileWriter2 = new FileWriter("resource/report.txt");

        StringBuilder builder = new StringBuilder();
        builder.append("доходы = ");
        builder.append(record1.getIncomes());
        builder.append(", расходы = ");
        builder.append(record1.getOutcomes());
        String data = builder.toString();

        System.out.println(data);
        fileWriter2.write(data);
        fileWriter2.close();

    }
}
