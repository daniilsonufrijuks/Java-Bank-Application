package managers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSVManager {
    public static void UpdateCSVFile(String lineToUpdate, String updatedLine) throws IOException {     // method to update line in csv file
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/person.csv")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine.replace(lineToUpdate, updatedLine)).append("\r\n");
            }
        }

        try (FileWriter fileWriter = new FileWriter("resources/person.csv")) {
            fileWriter.write(sb.toString());
        }
    }
}
