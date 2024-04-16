package managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreditManager {
    public float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            credit = (float) (money * Math.pow(1 + percents / 100, years));
            return credit;
        }
        return credit;
    }

    public static void WriteCredittoFile(String userpcode, float credit) {
        try {
            FileWriter writer = new FileWriter("resources/credits.csv", true);
            writer.write(userpcode + ", " + credit + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void Check(String userpcode) {
        String filepath = "resources/credits.csv";
        Float credit = FindCredit(filepath, userpcode);
        if (credit != null) {
            System.out.println("Credit: " + credit);
        } else {
            System.out.println("Credit not found");
        }
    }
}
