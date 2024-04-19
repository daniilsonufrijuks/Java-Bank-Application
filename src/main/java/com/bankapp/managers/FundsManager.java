package managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FundsManager {
    public static void WriteBoughtFunds(String userpcode, float amount, String fundname) {
        try {
            FileWriter writer = new FileWriter("resources/funds.csv", true);
            writer.write(userpcode + ", " + amount + ", " + fundname + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean CheckBoughtFunds(String userpcode) {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/funds.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 3 && parts[0].equals(userpcode)) {
                    return true;
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static float FindFund(String userpcode) {
        float amount = 0.0f;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/funds.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 3 && parts[0].equals(userpcode)) {
                    return Float.parseFloat(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amount;
    }
}
