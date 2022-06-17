package lesson3.expert;

// Предыстория: Мы находимся в статистическом институте. Хочется понять уровень миграции между регионами за месяц.
// Для этого было решено произвести анализ передвижения автомобилей: на границе каждого региона стоят камеры,
// фиксирующие въезд и выезд автомобилей. Формат автомобильного номера: (буква)(3 цифры)(2 буквы)(2-3 цифры)
// К474СЕ178 - где 178 регион

// Задача №1: составить топ-5 популярных регионов (куда больше всего въехали).
// Сделать аналитическую раскладку: машины какого региона больше всего въезжали в этот топ-5.
// Ожидаемый результат:
// ТОП-5: 98, 178, 01, 22, 33
// 98 - больше всего въехало с номерами 178: 23 машины
// 178 - больше всего въехало с номера 98: 50 машин
// 01 - больше всего въехало с номера 178: 11 машин
// 22 - больше всего въехало с номера 01: 30 машин
// 33 - больше всего въехало с номера 12: 100 машин

// Задача №2: узнать сколько всего машин со спец номерами: начинаются на M и заканчиваются на АВ.
// Не повторяющиеся

//Входящие данные
// Map<Integer, Map<String, String[]>> - где ключ первого уровня - номер региона,
// out, input - ключи второго уровня (выезд, въезд), и String[] - массивы номеров.
// { 1 : {
//      "out" : ["К474СЕ178"],
//      "input": ["А222РТ178"]
//    },
//   2 : {
//        "out" : ["К722АВ12", "А222РТ178"],
//        "input" : ["М001АВ01", "А023РВ73"],
//   }
// ..
//  }

//Список технологий:
// Set (HashSet) - узнать что это, set.contains(), set.put()
// Map (HashMap) - узнать что это, map.get(), map.put(), map.entrySet() - для итерации, entry.getValue(), entry.getKey()
// <Integer> - обозначает тип который хранится в этой структуре данных (Generics)
// Регулярные выражения - вытащить регион авто

import java.util.*;

public class Expert {
    public static void main(String[] args) {
        HashMap<Integer, Map<String, String[]>> data = new HashMap<>(GeneratorExpertHomework.getData());
        Map<Integer, Integer> regionNumberMap = returnRegionNumber(data);
        returnTopRegionsSortedMap(regionNumberMap);




    }

    public static Map<Integer, Integer> returnTopRegionsSortedMap(Map<Integer, Integer> inputData) {

        // Неудачная попытка посчитать топ регионов с номерами

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (var pair : inputData.entrySet()) {
            Integer region = pair.getKey();
            list.add(pair.getValue());
            Collections.sort(list);
            for (Integer numSorted : list) {
                for (Map.Entry<Integer, Integer> numMap : inputData.entrySet())
                    sortedMap.put(region, numSorted);

            }
        }
        System.out.println(sortedMap);
        return sortedMap;
    }




    public static Map<Integer, Integer> returnRegionNumber(HashMap<Integer, Map<String, String[]>> data) {

        //Достаем значения регионов и считаем, сколько всего машин въехало в каждый регион

        Map<Integer, Integer> regionCountMap = new HashMap<>();
        for (var map1 : data.entrySet()) {
            for (var map2 : map1.getValue().entrySet()) {
                Integer region = map1.getKey();
                String inputOutput = map2.getKey();
                String[] numbers = map2.getValue();
                if (inputOutput.equals("input")) {
                    int inputCarsCount = numbers.length;
                    regionCountMap.put(region, inputCarsCount);
                    System.out.println("Регион: " + region + ", кол-во въехавших: " + inputCarsCount);
                }
            }
        }
        return regionCountMap;
    }


    public static HashMap<Integer, String[]> returnInputCarNumbers(HashMap<Integer, Map<String, String[]>> data) {

        //Достаем регионы и номера въехавших машин

        HashMap<Integer, String[]> inputCarNumbersMap = new HashMap<>();
        for (var map1 : data.entrySet()) {
            for (var map2 : map1.getValue().entrySet()) {
                Integer region = map1.getKey();
                String inputOutput = map2.getKey();
                String[] numbers = map2.getValue();
                if (inputOutput.equals("input")) {
                    inputCarNumbersMap.put(region, numbers);
                    int dummy = numbers.length;
                    /*System.out.println("Регион: "
                            + region + ", въехало "
                            + dummy + " машин с номерами: "
                            + Arrays.toString(numbers));*/
                }
            }
        }
        return inputCarNumbersMap;
    }
}