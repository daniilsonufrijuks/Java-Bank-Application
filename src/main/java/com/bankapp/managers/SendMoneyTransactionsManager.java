package managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SendMoneyTransactionsManager {     // Class for operations with sending money and transactions related to them
    // Write credit transactions to a file
    public static void WriteMoneyTransactionsToafile(String recpcode, String sennickname, String senbankacc, Float money, LocalDate date) {
        try {
            FileWriter writer = new FileWriter("resources/sendmoneyTransactions.csv", true);
            writer.write(recpcode + ", " + sennickname + ", " + senbankacc + ", " + money + ", " + date + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // for money transaction/sending visualization , reads file sendmoneyTransactions.csv
    public static ArrayList<String[]> FindMoneyTransaction(String filepath, String recpcode) {
        ArrayList<String[]> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5 && parts[0].equals(recpcode)) {
                    transactions.add(new String[]{parts[4], parts[1], parts[2], parts[3]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
