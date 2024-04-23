package managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FundsManager implements DeleteFileData {
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

    public static float FindFund(String userpcode, String fundname) {
        float amount = 0.0f;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/funds.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 3 && parts[0].equals(userpcode) && parts[2].equals(fundname)) {
                    return Float.parseFloat(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static void DeleteMessage(String userpcode) {
        File inputFile = new File("resources/funds.csv");
        File tempFile = new File("resources/fundsTemp.csv");
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

    public static float CheckForSimilarFundsAndJoinSimilar(String userpcode, String fundname) {
        float amount = 0.0f;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/funds.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 3 && parts[0].equals(userpcode) && parts[2].equals(fundname)) {
                    amount += Float.parseFloat(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static void DeleteSimilarUserpcodeAndFundnamesinFile(String userpcode, String fundname) {
        File inputFile = new File("resources/funds.csv");
        File tempFile = new File("resources/fundsTemp.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with userpcode
                String trimmedLine = currentLine.trim();
                String[] parts = currentLine.split(", ");
                if (parts.length == 3 && parts[0].equals(userpcode) && parts[2].equals(fundname)) continue;
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
}
