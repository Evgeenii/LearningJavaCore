package Lesson_1;


import java.io.PrintStream;
import java.util.Arrays;

public class Lesson {
    public static void main(String[] args) {
        //Базовый уровень
        //Задача №1
        //Дано (их менять нельзя)

        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';

        //Создать из трех переменных единую строку,
        //Привести к правильному виду (Ниже)
        //затроить (Можно вызвать тольку одну команду System.out.print())
        //
        //Результат вывода на экран:
        //Hello world!
        //Hello world!
        //Hello world!

        String stringTrim = hi.trim() + world + newLine;
        String stringRepeat = stringTrim.repeat(3);

        System.out.println(stringRepeat);

        //Задача №2
        //Создать переменные с ростом, весом.
        //Произвести расчет индекса массы тела (вес) / (рост * рост) используя переменные, вывести на экран
        //Пример результата вывода на экран:
        //21.0

        double height = 190;
        double weight = 113;
        double bmi = (weight / (Math.pow(height, 2)));

        System.out.println(Math.floor(bmi * 10000) + "\n");

        //Задача №3
        //Создать из массива букв a,b,c,d,e, строку,вывести на экран , поменять в массиве 4 букву по счету на h,
        //и снова создать строку, вывести на экран

        String[] string = {"a", "b", "c", "d", "e"};
        System.out.println(Arrays.toString(string));
        string[3] = "h";
        System.out.println(Arrays.toString(string) + "\n");


        //Продвинутый уровень
        //Задача №1
        //Произвести преобразование "234" в число типа int и прибавить к этому числу длину строки "some_text"

        String nums = "234";
        String text = "some_text";
        int someTextLength = text.length();
        int numsNumEquivalent = Integer.parseInt(nums);

        System.out.println(numsNumEquivalent + someTextLength + "\n");

        //Задача №2
        //Посчитать (a+b)^2 = ?, при a=3, b=5

        int a = 3;
        int b = 5;
        int sum = 8;
        System.out.println((int) Math.pow(sum, 2) + "\n");


        //Задача №3
        //Создать два массив чисел:
        // 1,2,5,7,10
        // 2,3,2,17,15
        // Создать массив чисел, в котором будут: все числа из этих двух массивов,
        // и результат умножения чисел с одинаковым порядковым номером
        //
        //Ожидаемый результат:
        //1,2,5,7,10,2,3,2,17,15,2,6,10,119,150
        //(первый массив - 1,2,5,7,10), (второй массив - 2,3,2,17,15),
        //(результат перемножения - (1*2), (2*3), (5*2), (7*17), (10*15)


        int[] nums1 = {1, 2, 5, 7, 10};
        int[] nums2 = {2, 3, 2, 17, 15};
        int[] numsFusion = new int[nums1.length + nums2.length]; // length = 10
        int[] numsMultiplied = new int[nums1.length]; // length = 5
        int[] numsResult = new int[numsFusion.length + nums1.length]; // length = 15;

        System.arraycopy(nums1, 0, numsFusion, 0, nums1.length);
        System.arraycopy(nums2, 0, numsFusion, nums1.length, nums2.length);
        System.arraycopy(numsFusion, 0, numsFusion, 0, numsFusion.length);

        for (int i = 0; i < nums1.length; i++) numsMultiplied[i] = nums1[i] * nums2[i];

        System.arraycopy(numsFusion, 0, numsResult, 0, numsFusion.length);
        System.arraycopy(numsMultiplied, 0, numsResult, numsFusion.length, numsMultiplied.length);
        System.arraycopy(numsResult, 0, numsResult, 0, numsResult.length);

        System.out.println(Arrays.toString(numsResult) + "\n");


        //Задача №4
        //В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов

        String helloWorld = "Hello world";
        String newHelloWorld = helloWorld.replace("l", "r");
        System.out.println(newHelloWorld.toUpperCase());

        // не понял, что такое - "выбрать первые 8 символов"





        //Экспертный уровень
        //Задача №1
        //Создать метод маскирования персональных данных, который:
        //Телефон (до/после маскирования): 79991113344 / 7999***3344
        //Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
        //Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
        //
        //Входящие параметры: String text
        //Возвращаемый результат: String
        //
        //Примеры возможного текста:
        //<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client> - "<client>(Какие то данные)<data>7999***3344;tes*@******.ru;И****в Иван И.</data></client>"
        //<client>(Какие то данные)<data></data></client> - вернет тоже (никаких ошибок)
        //<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client> - "<client>(Какие то данные)<data>И****в Иван И.;7999***3344</data></client>"

        //Используемые технологии: String.find, String.replaceAll, String.split, String.join, String.contains, String.substring
        //Регулярные выражения, класс StringBuilder


    }
}