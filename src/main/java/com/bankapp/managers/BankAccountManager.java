package managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.Transaction;

import java.math.BigDecimal;
// BigDecimal is datatype for money
import java.math.RoundingMode;

public class BankAccountManager implements DeleteFileData {       // Class for monetary transactions (send, get money etc.)
    
    // method to send money to another account
    public static boolean SendMoney (Transaction transaction){
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                for (String string : parts) {
                    System.out.println("SendMoney results parts: " + string);
                }
                
                if (parts.length == 10 && parts[6].equals(transaction.getUsername()) && parts[4].equals(transaction.getBankaccount())) {
                    String[] duplParts = parts;           // csv line duplicate to use in Update method    
                    String duplPartsStr = String.join(", ", duplParts);
                    BigDecimal moneyToSendBD = new BigDecimal(transaction.getAmount());                 // money to send convert to BigDecimal
                    BigDecimal receiverCurrentCapital = new BigDecimal(parts[9]);           // current receiver's capital convert to BigDecimal
                    receiverCurrentCapital = receiverCurrentCapital.add(moneyToSendBD).setScale(2, RoundingMode.HALF_EVEN);     // new receiver's capital rounded down to 2 decimal places
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
    public static BigDecimal GetBalance(String PersonalID) {
        BigDecimal balance = new BigDecimal(0);
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                // for (String string : parts) {
                //     System.out.println("GetBalance results parts: " + string);
                // }
                if (parts.length == 10) {
                    if (parts[3].equals(PersonalID)) {
                        BigDecimal balanceFound = new BigDecimal(parts[9]).setScale(2, RoundingMode.HALF_EVEN);      // if the length of the parts is 10
                        return balanceFound;         
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
                    System.out.println(" -----> ");
                    System.out.println("money: " + money);
                    System.out.println("userpcode: " + userpCode);
                    System.out.println(" -----> ");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) {
            // ---------------------------------------------------------------------
            String line;
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

    // method to remove money from the sender's account
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

    // method to find bank account
    public static String FindBankAccount(String usepCode) {
        String bankAcc = "";
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                // for (String string : parts) {
                //     System.out.println("GetBalance results parts: " + string);
                // }
                if (parts.length == 10) {
                    if (parts[3].equals(usepCode)) {
                        bankAcc = parts[4];         
                        return bankAcc;         
                    }   // balance is the 10th part of the csv line
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankAcc;
    }

    // method to take money from the account
    public static float TakeMoney(Transaction transaction) {
        float money = 0.0f;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 10) {
                    if (parts[3].equals(transaction.getUsername())) {
                        money = Float.parseFloat(parts[9]);         
                        return money;         
                    }   // balance is the 10th part of the csv line
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return money;
    }

    // method to show message when money is sent
    public static void ShowMessagewhenMoneysent(String senderuserpcode, Float money, String userpcode) {
        try{
            FileWriter regWriter = new FileWriter("resources/messagetosend.csv", true); // create a new file writer object
            regWriter.write(senderuserpcode + ", " + money + ", " + userpcode + "\n");
            regWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to find person code   
    public static String FindPersonPcode(String bankacc) {
        String pcode = "";
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                // for (String string : parts) {
                //     System.out.println("GetBalance results parts: " + string);
                // }
                if (parts.length == 10) {
                    if (parts[4].equals(bankacc)) {
                        pcode = parts[3];         
                        //return pcode;         
                    }   // balance is the 10th part of the csv line
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pcode;
    } 

    // method to show message when money is received
    public static boolean IfSomebodySentMoney(String userpcode) {
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/messagetosend.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 3 && parts[2].equals(userpcode)) {
                    result = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void DeleteMessage(String userpcode) {
        File inputFile = new File("resources/messagetosend.csv");
        File tempFile = new File("resources/messagetosendTemp.csv");
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

    public static String FindPinCodes(String userpcode) {
        String pinCode = "";
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 10) {
                    if (parts[3].equals(userpcode)) {
                        pinCode = parts[7];         
                        return pinCode;         
                    } 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pinCode;
    }

    public static String FindPinCodesSecond(String userpcode) {
        String pinCode = "";
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");      // current line from csv file
                if (parts.length == 10) {
                    if (parts[3].equals(userpcode)) {
                        pinCode = parts[8];         
                        return pinCode;         
                    } 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pinCode;
    }
}
