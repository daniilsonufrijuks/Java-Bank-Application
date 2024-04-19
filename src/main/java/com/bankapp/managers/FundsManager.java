package managers;

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
}
