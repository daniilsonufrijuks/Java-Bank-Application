package controller;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

import model.Person;

public class Registration{      // Registration lass

    // method writes to file given fields through person 
    public void WriteToAFile(Person personToWriteIn){
        try{
            PinKontGen gen = new PinKontGen(); // create a new object of PinKontGen
            String pin1Str = String.valueOf(gen.GenPinS()); // convert pin1 to string
            String pin2Str = String.valueOf(gen.GenPinS());
            String accountID = gen.GenKontnum();
            File csvObj = new File("resources/person.csv"); // create a new file object
            Scanner regReader = new Scanner(csvObj);
            int line_id = 1;
            while (regReader.hasNextLine()) { // while there is a next line
                String data = regReader.nextLine();
                System.out.println(line_id + " " + data);
                line_id++;
            }
            FileWriter regWriter = new FileWriter("resources/person.csv", true); // create a new file writer object
            regWriter.write(String.valueOf(line_id) + ", " +  personToWriteIn.GetName() + ", " +  personToWriteIn.GetLastName() + ", " + personToWriteIn.GetPersonCode() + ", " +  accountID + ", " + personToWriteIn.GetEmail() + ", " + personToWriteIn.GetNickName() + ", " + pin1Str + ", " +  pin2Str + ", " + "0" + "\n");
            regWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
