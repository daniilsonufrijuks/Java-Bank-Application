package test.java.com.bankapp.controller;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import managers.CreditManager;

public class CreditManagerTest {    // This Unit Test uses csv file creditManagerTestFile.csv to test methods. This csv file is not usable in the program itself.
    @Test
    public void GenCreditTest() {
        float money = 1000.0f;
        float percents = 10.0f;
        int years = 1;
        assertEquals(1100.0f, CreditManager.GenCredit(money, percents, years), 0);
    }

    @Test
    public void WriteCredittoFileTest(){    // body is taken from CreditManager.java method WriteCredittoFile. Here the pathfile is changed
        try {
            FileWriter writer = new FileWriter("resources/creditManagerTestFile.csv", true);
            writer.write("999999-99999" + ", " + 221.34 + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FindCreditTest(){
        assertEquals(Float.valueOf("120.0"), CreditManager.FindCredit("resources/creditManagerTestFile.csv", "111111-11111"));
        assertEquals(Float.valueOf("144.87"), CreditManager.FindCredit("resources/creditManagerTestFile.csv", "222222-22222"));
    }

    @Test
    public void DeleteMessageTest(){                            // body is taken from CreditManager.java method DeleteMessage. Here the pathfiles are changed
        String userpcode = "999999-99999";
        File inputFile = new File("resources/creditManagerTestFile.csv");
        File tempFile = new File("resources/creditManagerTestFileNew.csv");
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
}
