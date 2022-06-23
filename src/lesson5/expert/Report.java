package lesson5.expert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.*;

public class Report {

    //переписать все нормально

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final String SHOP = "pyterochka";


    public static void doReport() throws IOException {
        List<String> dataFromFiles = getData();
        Map<Integer, String> report = getReport(dataFromFiles);
        Map<String, Double> reportTask2 = getReportTask2(dataFromFiles);
        printReport(report, reportTask2);

    }

    private static void printReport(Map<Integer, String> report1, Map<String, Double> report2) {
        System.out.println( "Прибыль по магазину " + SHOP + " по месяцам ");
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
        for (var strings : dataFromFiles) {
            String[] rawData = strings.split("\n");
            for (String data : rawData) {
                if (!data.equals("магазин;доход;расход;дата") && !data.isEmpty()) {
                    String[] splitedData = data.split(";");
                    String shop = splitedData[0];
                    double outcomes = Double.parseDouble(splitedData[2]);
                    if (report2.get(shop) == null) {
                        report2.put(shop, outcomes);
                    } else {
                        report2.replace(shop, report2.get(shop) + outcomes);
                    }
                }
            }
        }

        return report2;
    }

    private static Map<Integer, String> getReport(List<String> dataFromFiles) {
        Map<Integer, String> report = new HashMap<>();
        for (var strings : dataFromFiles) {
            String[] splitedData = strings.split("\n");
            double profit = 0;
            for (String dataString : splitedData) {
                if (dataString.contains(SHOP)) {
                    String[] currentShop = dataString.split(";");
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
        }
        return report;
    }

    private static List<String> getData() {
        File[] files = new File("resource/").listFiles();
        List<String> dataFromFiles = new ArrayList<>();

        for (File file : files) {
            if (file.getName().endsWith("2012.txt")) {
                String data = null;
                try {
                    data = Files.readString(Path.of(file.getPath()));
                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
                dataFromFiles.add(data);
            }
        }
        return dataFromFiles;
    }
}