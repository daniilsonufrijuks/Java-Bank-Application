package managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreditManager {
    // generate credit depending on money, percents and years
    public static float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            credit = (float) (money * Math.pow(1 + percents / 100, years));
            return credit;
        }
        return credit;
    }

    // write taken credit to a file
    public static void WriteCredittoFile(String userpcode, float credit) {
        try {
            FileWriter writer = new FileWriter("resources/credits.csv", true);
            writer.write(userpcode + ", " + credit + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // find credit in a file
    public static Float FindCredit(String filepath, String userpcode) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 2 && parts[0].equals(userpcode)) {
                    return Float.parseFloat(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void DeleteMessage(String userpcode) {
        File inputFile = new File("resources/credits.csv");
        File tempFile = new File("resources/creditsTemp.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with userpcode
                String trimmedLine = currentLine.trim();
                if (trimmedLine.contains(userpcode)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Delete the original file
        if (!inputFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        //Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename file");
        }
    }

    // Check for similar user pcode in file and sum values and delete similar mess
    public static void CheckForSimilarUserPcodeinFileandSumValues(String userpcode) {
        try {
            File file = new File("resources/credits.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {    // saves all file in array
                lines.add(line);
            }
            reader.close();
    
            BigDecimal sum = BigDecimal.ZERO; // total credit
            BigDecimal pMoneyToBG;
            for (String l : lines) {
                String[] parts = l.split(", ");
                if (parts[0].equals(userpcode)) {       // if user's pcode is repeated
                    pMoneyToBG = new BigDecimal(parts[1]);
                    sum = sum.add(pMoneyToBG);
                    System.out.println("sum is " + sum);
                }
            }

            sum.setScale(2, RoundingMode.HALF_UP);  // round to 2 dec positions
                
            if (sum.compareTo(BigDecimal.ZERO) > 0) {   // if value is > 0
                System.out.println("sum.compareTo(BigDecimal.ZERO) > 0 is made");
                DeleteMessage(userpcode);
                WriteCredittoFile(userpcode, sum.floatValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                    transactions.add(new String[]{parts[0], parts[1], parts[2], parts[3], parts[4]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    // public static void CheckForSimilarUserPcodeinFileandSumValues(String userpcode) {
    //     try {
    //         File file = new File("resources/credits.csv");
    //         BufferedReader reader = new BufferedReader(new FileReader(file));
    //         String line;
    //         List<String> lines = new ArrayList<>();
    //         while ((line = reader.readLine()) != null) {
    //             lines.add(line);
    //         }
    //         reader.close();
    
    //         float sum = 0.0f;
    //         for (String l : lines) {
    //             String[] parts = l.split(", ");
    //             if (parts[0].equals(userpcode)) {
    //                 sum += Float.parseFloat(parts[1]);
    //             }
    //         }
    
    //         if (sum > 0) {
    //             DeleteMessage(userpcode);
    //             WriteCredittoFile(userpcode, sum);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
