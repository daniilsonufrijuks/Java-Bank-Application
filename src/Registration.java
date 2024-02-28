import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

static class Registration{      // Registration static class

    static void WriteToAFile(Person personToWriteIn, String accountID, int pin1, int pin2){
        try{
            String pin1Str = String.valueOf(pin1);
            String pin2Str = String.valueOf(pin2);
            FileWriter regWriter = new FileWriter("person.csv");
            regWriter.write(/*id??*/personToWriteIn.GetName(), personToWriteIn.GetLastName(), personToWriteIn.GetPersonCode(), accountID, personToWriteIn.GetEmail(), pin1Str, pin2Str, "0");
            regWriter.close();
        } catch (IOException e) {
            ... // Registration error
        }
    }

}
