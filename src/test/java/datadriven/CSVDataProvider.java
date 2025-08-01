package datadriven;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class CSVDataProvider {
    public static Iterator<Object[]> getDataFromCSV() {
        List<Object[]> testData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("puneet-1302027-addressbook-data.csv"))) {
            String[] line;
            int rowNum = 0;
            reader.readNext(); // Skip header
            while ((line = reader.readNext()) != null) {
                rowNum++;
                if (line.length == 23) {
                    testData.add(line);
                } else {
                    System.out.println("⚠️ Skipping row " + rowNum + ": Expected 23 columns but found " + line.length);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData.iterator();
    }
}
