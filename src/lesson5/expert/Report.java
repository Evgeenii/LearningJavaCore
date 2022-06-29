package lesson5.expert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.*;


public class Report {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final String SHOP = "pyterochka";

    public static void doReport() throws IOException {
        List<String> filesPathList = getFileNames();
        List<String> rawDataList = getRawDataList(filesPathList);
        Map<Integer, String> report = getReport(rawDataList);
        Map<String, Double> reportTask2 = getReportTask2(rawDataList);
        printReport(report, reportTask2);

    }

    private static void printReport(Map<Integer, String> report1, Map<String, Double> report2) {
        System.out.println("Прибыль по магазину " + SHOP + " по месяцам ");

        for (Map.Entry<Integer, String> entry : report1.entrySet()) {
            String[] dataArray = entry.getValue().split("\\.");
            String profitPerMonth = entry.getValue();
            System.out.println(profitPerMonth);
        }

        System.out.println();

        for (Map.Entry<String, Double> entry : report2.entrySet()) {
            String shop = entry.getKey();
            Double outcomes = entry.getValue();
            System.out.println("Расходы " + shop + " за весь период: "
                    + df.format(outcomes));
        }
    }

    private static Map<String, Double> getReportTask2(List<String> dataFromFiles) {
        Map<String, Double> report2 = new HashMap<>();
        for (String strings : dataFromFiles) {
            String[] splitedData = strings.split(";");
            String shop = splitedData[0];
            double outcomes = Double.parseDouble(splitedData[2]);
            if (report2.get(shop) == null) {
                report2.put(shop, outcomes);
            } else {
                report2.replace(shop, report2.get(shop) + outcomes);
            }
        }
        return report2;
    }

    private static Map<Integer, String> getReport(List<String> dataFromFiles) {
        Map<Integer, String> report = new HashMap<>();
        for (String strings : dataFromFiles) {
            double profit = 0;
            if (strings.contains(SHOP)) {
                String[] currentShop = strings.split(";");
                String incomes = currentShop[1];
                String outcomes = currentShop[2];
                String date = currentShop[3];
                String[] dateArray = date.split("/");
                int month = Integer.parseInt(dateArray[1]);
                int year = Integer.parseInt(dateArray[2]);
                profit += Double.parseDouble(incomes) - Double.parseDouble(outcomes);
                StringBuilder profitPerMonth = new StringBuilder();
                if (month < 10) {
                    profitPerMonth.append("0")
                            .append(month)
                            .append(".")
                            .append(year)
                            .append(": ")
                            .append(df.format(profit));
                    report.put(month, profitPerMonth.toString());
                } else {
                    profitPerMonth.append(month)
                            .append(".")
                            .append(year)
                            .append(": ")
                            .append(df.format(profit));
                    report.put(month, profitPerMonth.toString());
                }
            }
        }
        return report;
    }

    private static List<String> getRawDataList(List<String> list) throws IOException {
        List<String> rawData = new ArrayList<>();
        for (String file : list) {
            if (file.endsWith("2012.txt")) {
                file = Files.readString(Path.of(file)).replaceAll("\r", "");
                if (file.contains("магазин;доход;расход;дата")) {
                    String cleanString = file.replaceAll("магазин;доход;расход;дата", "");
                    if (!cleanString.isEmpty()) {
                        Collections.addAll(rawData, cleanString.split("\n"));
                        rawData.removeAll(Arrays.asList("", null)); // нашел в List пустую строку на выходе
                    }

                }
            }
        }
        return rawData;
    }

    private static List<String> getFileNames()  {
        File[] files = new File("resource/").listFiles();
        List<String> filesPathList = new ArrayList<>();
        String fileName;
        if (files != null) {
            for (File filePath : files) {
                if (filePath.toString().endsWith("2012.txt")){
                    fileName = filePath.toString();
                    filesPathList.add(fileName);
                }
            }
        }
        return filesPathList;
    }
}