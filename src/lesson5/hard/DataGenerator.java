package lesson5.hard;

import lesson5.easy.FinancialRecord;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class DataGenerator {

    private static final Random RANDOM = new Random(1);
    private static final int COUNT_DAYS = 10;


    private static FinancialRecord generateRandomRecord() {

        double randomDoubleIn = RANDOM.nextDouble() * 1000;
        BigDecimal bigDecimal = new BigDecimal(randomDoubleIn);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_DOWN);
        double randomIn = bigDecimal.doubleValue();


        double randomDoubleOut = RANDOM.nextDouble() * 1000;
        BigDecimal bigDecimalOut = new BigDecimal(randomDoubleOut);
        bigDecimalOut = bigDecimalOut.setScale(2, RoundingMode.HALF_DOWN);
        double randomOut = bigDecimalOut.doubleValue();


        return new FinancialRecord(randomIn, randomOut);

    }


    public static String createReport() {

        FinancialRecord[] records = new FinancialRecord[COUNT_DAYS];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < records.length; i++) {
            records[i] = generateRandomRecord();
        }

        for (int i = 0; i < records.length; i++) {
            builder.append("склад: ");
            builder.append(i + 1);
            builder.append(", доходы = ");
            builder.append(records[i].getIncomes());
            builder.append(", расходы = ");
            builder.append(records[i].getOutcomes());
            builder.append("\n");

        }
        return builder.toString();
    }

    public static void writeReport(String data) throws IOException {

        FileWriter writer = new FileWriter("resource/report2.txt");
        writer.write(data);
        writer.close();

    }
}

