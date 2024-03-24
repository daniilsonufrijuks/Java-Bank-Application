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
import java.math.RoundingMode;

public class BankAccountManager {       // Class for monetary transactions (send, get money etc.)
    
    // method to send money to another account
    public static boolean SendMoney (String recUsername, String recBankAcc, float moneyToSend){
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                for (String string : parts) {
                    System.out.println("SendMoney results parts: " + string);
                }
                
                if (parts.length == 10 && parts[6].equals(recUsername) && parts[4].equals(recBankAcc)) {
                    String[] duplParts = parts;           // csv line duplicate to use in Update method    
                    String duplPartsStr = String.join(", ", duplParts);
                    BigDecimal moneyToSendBD = new BigDecimal(moneyToSend);                 // money to send convert to BigDecimal
                    BigDecimal receiverCurrentCapital = new BigDecimal(parts[9]);           // current receiver's capital convert to BigDecimal
                    receiverCurrentCapital = receiverCurrentCapital.add(moneyToSendBD).setScale(2, RoundingMode.DOWN);     // new receiver's capital rounded down to 2 decimal places
                    parts[9] = receiverCurrentCapital.toString();                           // new capital value for receiver
                    String partsStr = String.join(", ", parts);

                    CSVManager.UpdateCSVFile(duplPartsStr, partsStr);
                    result = true;
                    break;
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
                    if (parts[3].equals(PersonalID) && parts[6].equals(Username)) {                             // if the length of the parts is 10
                        return balance = Integer.parseInt(parts[9]);           
                    }   // balance is the 10th part of the csv line
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    }   

    public static boolean CheckSendData(String recUsername, String recBankAcc, float moneyToSend, String userpCode) {
        boolean result = false;
        Float money = 0.0f;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                
                if (parts.length == 10 && parts[3].equals(userpCode)) {    // find the needed account
                    money = Float.parseFloat(parts[9]);
                    //System.out.println(moneyToSend);
                    System.out.println(money);
                    System.out.println(userpCode);
                    break;
                }
            }
            // ---------------------------------------------------------------------
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                for (String string : parts) {
                    System.out.println("CheckSendData results parts: " + string);
                }
                // ?????
                //Float money = 0.0f;
                // if (parts.length == 10 && parts[3].equals(userpCode)) {    // find the needed account
                //     money = Float.parseFloat(parts[9]);
                //     //System.out.println(moneyToSend);
                //     System.out.println(money);
                //     System.out.println(userpCode);
                // }
                if (parts.length == 10 && parts[4].equals(recBankAcc) && parts[6].equals(recUsername) && money >= moneyToSend) {    // find the needed account
                    System.out.println(Float.parseFloat(parts[9]) + " >= " + moneyToSend);
                    result = true;
                    break;
                } else {
                    System.out.println("Invalid username or bank account!");
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean RemoveMoneyFromSenderInCSVAfterSendMoney(String Pcode, String email, float sentMoney){
        boolean remMoneyResult = false;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                for (String string : parts) {
                    System.out.println("RemoveMoneyFromSenderAfterSendMoney results parts: " + string);
                }
                
                if (parts.length == 10 && parts[3].equals(Pcode) && parts[5].equals(email)) {
                    String[] duplParts = parts;           // csv line duplicate to use in Update method    
                    String duplPartsStr = String.join(", ", duplParts);
                    BigDecimal sentMoneyBD = new BigDecimal(sentMoney);               // sent money (aka money that have to be taken) convert to BigDecimal
                    BigDecimal receiverCurrentCapital = new BigDecimal(parts[9]);           // current receiver's capital convert to BigDecimal
                    receiverCurrentCapital = receiverCurrentCapital.subtract(sentMoneyBD).setScale(2, RoundingMode.DOWN);     // new receiver's capital rounded down to 2 decimal places
                    parts[9] = receiverCurrentCapital.toString();                           // new capital value for receiver
                    String partsStr = String.join(", ", parts);

                    CSVManager.UpdateCSVFile(duplPartsStr, partsStr);
                    remMoneyResult = true;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return remMoneyResult;
    }

}
