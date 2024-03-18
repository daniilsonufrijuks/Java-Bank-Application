package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.math.BigDecimal;
// BigDecimal is datatype for money

public class BankAccountManager {       // Class for monetary transactions (send, get money etc.)
    
    public static boolean SendMoney (String[] receiver, float moneyToSend){
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                for (String string : parts) {
                    System.out.println("SendMoney results parts: " + string);
                }

                for (String str : receiver){
                    System.out.println("SendMoney results receiver: " + str);
                }
                
                if (parts.length == 10 && parts[1].equals(receiver[1]) && parts[2].equals(receiver[2]) &&   // need to check and probably change if statement
                parts[3].equals(receiver[3]) && parts[4].equals(receiver[4]) && parts[5].equals(receiver[5])
                && parts[6].equals(receiver[6])) {                              // if the length of the parts is 10 and the parts are equal to the given fields
                    String[] duplParts = parts;           // csv line duplicate to use in Update method    
                    String duplPartsStr = String.join(", ", duplParts);
                    BigDecimal moneyToSendBD = new BigDecimal(moneyToSend);                 // money to send convert to BigDecimal
                    BigDecimal receiverCurrentCapital = new BigDecimal(parts[9]);           // current receiver's capital convert to BigDecimal
                    receiverCurrentCapital = receiverCurrentCapital.add(moneyToSendBD);     // new receiver's capital
                    parts[9] = receiverCurrentCapital.toString();                           // new capital value for receiver
                    String partsStr = String.join(", ", parts);

                    CSVManager.UpdateCSVFile(duplPartsStr, partsStr);
                    result = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // to get balance of the user
    public static int GetBalance(String PersonalID, String Username) {
        int balance = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                // for (String string : parts) {
                //     System.out.println("GetBalance results parts: " + string);
                // }
                if (parts.length == 10) {
                    if (parts[3].equals(PersonalID) && parts[6].equals(Username))                              // if the length of the parts is 10
                        balance = Integer.parseInt(parts[9]);              // balance is the 10th part of the csv line
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    } 
}
