package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Person;

public class PersCode_Email_Controller {

    public static boolean PersCodeCheckIfInCSVFile(Person person){    // checks if person's personal code already exists in csv file
        boolean checkPassed = true;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");
                for (String string : parts) {
                    System.out.println(string);
                }
                
                if (parts.length == 10 && parts[3].equals(person.GetPersonCode())){    // if person code is found (already exists in file)
                    checkPassed = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return checkPassed;

    }

    public static boolean EmailCheckIfInCSVFile(Person person){    // checks if person's email already exists in csv file
        boolean checkPassed = true;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/person.csv"))) { // create a new buffered reader object
            String line;
            while ((line = br.readLine()) != null) { // while there is a next line
                String[] parts = line.split(", ");
                for (String string : parts) {
                    System.out.println(string);
                }
                
                if (parts.length == 10 && parts[5].equals(person.GetEmail())){    // if email is found (already exists in file)
                    checkPassed = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return checkPassed;

    }

}
