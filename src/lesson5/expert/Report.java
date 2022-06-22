package lesson5.expert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Report {


    public static void doReport() throws IOException {

        List<String> dataFromFiles = getData();
        Map<Integer, String> report = getReport(dataFromFiles);
        printReport(report);


    }

    private static void printReport(Map<Integer, String> fromReportDataMap) {

        for (Map.Entry<Integer, String> entry : fromReportDataMap.entrySet()) {
            String[] dataArray = entry.getValue().split(".");

            StringBuilder builder = new StringBuilder();
            builder.append("Прибыль магазина Пятерочка за ");
            builder.append(entry.getValue());
            System.out.println(builder.toString());

        }

    }


    private static Map<Integer, String> getReport(List<String> dataFromFiles) {

        Map<Integer, String> report = new HashMap<>();
        for (var strings : dataFromFiles) {
            String[] splitedData = strings.split("\n");
            for (String dataString : splitedData) {
                if (dataString.contains("pyterochka")) {
                    String[] currentShop = dataString.split(";");
                    String incomes = currentShop[1];
                    String date = currentShop[3];
                    String[] dateArray = date.split("/");
                    String month = dateArray[1];
                    String year = dateArray[2];
                    int index = Integer.parseInt(month);
                    String monthAndYear = month + " месяц " + year;
                    report.put(index, monthAndYear + " года" + ": " + incomes + " руб.");

                }

            }

        }
        return report;
    }


    private static List<String> getData() throws IOException {

        File[] files = new File("resource/").listFiles();
        List<String> dataFromFiles = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith("2012.txt")) {
                    String data = Files.readString(Path.of(file.getPath()));
                    dataFromFiles.add(data);
                }
            }
        }

        return dataFromFiles;
    }
}
